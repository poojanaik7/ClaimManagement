package com.memberservice.controller;


import com.memberservice.entity.Bills;
import com.memberservice.entity.MemberPolicy;
import com.memberservice.model.MemberPolicyRequest;
import com.memberservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MemberService memberService;

    @GetMapping("/claimStatus")
    public String getClaimStatus() {
       String status = restTemplate.getForObject("http://CLAIM-SERVICE/claims/claimStatus",String.class);
       return status;
    }

    @PostMapping("/enrolPolicy")
    public ResponseEntity<?> enrolPolicy(@RequestBody MemberPolicyRequest request) {
        MemberPolicy memberPolicy = memberService.enrolPolicy(request);
        return ResponseEntity.ok(memberPolicy);
    }

   @GetMapping("/viewBills")
    public ResponseEntity<?> viewBills(@RequestParam Integer memberId) {
       List<Bills> bills = memberService.viewBills(memberId);
       return ResponseEntity.ok(bills);
    }
}
