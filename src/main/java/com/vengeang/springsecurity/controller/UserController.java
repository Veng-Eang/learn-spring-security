package com.vengeang.springsecurity.controller;

import com.vengeang.springsecurity.model.Customer;
import com.vengeang.springsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer) {

        try {
            String encode = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(encode);
            Customer customerSave = customerRepository.save(customer);
            return ResponseEntity.created(new URI("/account/"+customerSave.getId())).body("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User registration failed");
        }
    }
}
