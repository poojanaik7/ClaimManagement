package com.memberservice.controller;


import com.memberservice.model.BillsResponse;
import com.memberservice.model.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/claimStatus")
    public String getClaimStatus() {
       String status = restTemplate.getForObject("http://CLAIM-SERVICE/claims/claimStatus",String.class);
       return status;
    }

    @GetMapping("/viewBills")
    public ResponseEntity<?> viewBills(@RequestParam Integer id) {
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        responseEntity = restTemplate.getForEntity("http://POLICY-SERVICE/policy/viewBills?memberId=id}",BillsResponse.class);
        return responseEntity;
    }
}
