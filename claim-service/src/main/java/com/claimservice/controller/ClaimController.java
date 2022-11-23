package com.claimservice.controller;


import com.claimservice.entity.Claims;
import com.claimservice.model.ClaimsRequest;
import com.claimservice.service.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/viewClaimStatus", method = RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Claims> getClaimStatus(@RequestParam Integer memberId) {
        Iterable<Claims> claims = claimsService.viewClaimStatus(memberId);
        return claims;
    }
}
