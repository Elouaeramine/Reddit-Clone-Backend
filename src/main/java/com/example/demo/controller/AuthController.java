package com.example.demo.controller;

import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/signup",consumes = "application/json")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest){

        authService.signup(registerRequest);
        return new ResponseEntity<>( "User Registration Successful " , HttpStatus.OK);

    }


    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token){
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successfully " , HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}
