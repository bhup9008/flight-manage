package com.codingworld.service1.controller;

import com.codingworld.service1.model.User;
import com.codingworld.service1.response.ResponseHandler;
import com.codingworld.service1.service.AuthService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService service;


    @GetMapping("/test")
    public String test() {
        return "Successfully fetch data!";
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") Long id) {
        User user=service.getUserById(id);
        return ResponseHandler.generateResponse("Successfully fetch data!",
                HttpStatus.OK, user);
    }





}
