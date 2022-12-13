package com.digitalhouse.claimsservice.controller;

import com.digitalhouse.claimsservice.model.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimController {

    @GetMapping("{id}")
    private ResponseEntity<UserResponse> findByID(@PathVariable String id) {
        return ResponseEntity.ok(new UserResponse("CINZA - VINDO DA CLAIMS", "BRASILEIRO"));
    }
}
