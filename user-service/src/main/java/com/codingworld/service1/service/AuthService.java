package com.codingworld.service1.service;

import com.codingworld.service1.ExceptionHandler.ResoureNotFoundException;
import com.codingworld.service1.model.ERole;
import com.codingworld.service1.model.Role;
import com.codingworld.service1.model.User;
import com.codingworld.service1.payload.SignupRequest;
import com.codingworld.service1.repository.RoleRepository;
import com.codingworld.service1.repository.UserRepository;
import com.codingworld.service1.response.MessageResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public MessageResponse saveUser(SignupRequest user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return new MessageResponse("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return new MessageResponse("Error: Email is already in use!");
        }

        // Create new user's account
        User user1 = new User(user.getUsername(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),user.getPhoneNumber());

        Set<String> strRoles = user.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user1.setRoles(roles);
        userRepository.save(user1);

        return new MessageResponse("User registered successfully!");

    }


    public User getUserById(Long id){
        User user=null;
        Optional<User> optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent()){
            user=optionalUser.get();
        }else {
            throw new ResoureNotFoundException("User not in db " +id);
        }
        return user;
    }





}
