package com.claimservice.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("claims")
public class ClaimController {


    @GetMapping("/claimStatus")
    public String getClaimStatus() {
        String status = "Process";
        return status;
    }
}
