package com.codingworld.service1.controller;

import com.codingworld.service1.payload.LoginRequest;
import com.codingworld.service1.payload.SignupRequest;
import com.codingworld.service1.response.JwtResponse;
import com.codingworld.service1.response.MessageResponse;
import com.codingworld.service1.response.ResponseHandler;
import com.codingworld.service1.service.AuthService;
import com.codingworld.service1.service.JwtService;
import com.codingworld.service1.service.UserDetailsImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/auth")
public class AuthController {

    //DispatcherServlet

    Logger logger= LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService service;



    @Autowired
    private  JwtService jwtService;



    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> addNewUser(@RequestBody @Valid SignupRequest user) {
        try {
            MessageResponse response=service.saveUser(user);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/token")
    public ResponseEntity<Object> getToken(@RequestBody LoginRequest loginRequest) {
        System.out.println("Auth request");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @GetMapping("/validate")
    public ResponseEntity<Object> validateToken(@RequestParam("token") String token) {
        System.out.println("asdkjsdjowejodm");
        try {
            boolean b=jwtService.validateJwtToken(token);


            return ResponseHandler.generateResponse("Token validation Successfully ", HttpStatus.OK, "Token is valid");

        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }



    }

    @GetMapping("/test")
    public String test() {
        return "Successfully fetch data!";
    }


}
