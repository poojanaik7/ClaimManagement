package com.claimservice.controller;


import com.claimservice.entity.Claims;
import com.claimservice.model.ClaimsRequest;
import com.claimservice.service.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("claims")
public class ClaimController {

    @Autowired
    ClaimsService claimsService;

    @PostMapping("/submitClaim")
    public ResponseEntity<?> submitClaim(@RequestBody ClaimsRequest request) {
        Claims claims = claimsService.submitClaims(request);
        return ResponseEntity.ok(claims);
    }

    @GetMapping("/viewClaimStatus")
    public ResponseEntity<?> getClaimStatus() {
        Iterable<Claims> claims = claimsService.viewClaimStatus();
        return ResponseEntity.ok(claims);
    }
}
