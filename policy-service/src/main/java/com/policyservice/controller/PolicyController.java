package com.policyservice.controller;

import com.policyservice.entity.*;
import com.policyservice.model.MemberPolicyRequest;
import com.policyservice.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @GetMapping("/viewPolicy")
    public ResponseEntity<?> getPolicy(@RequestParam Integer policyNumber) {
        Policy policy = policyService.getPolicy(policyNumber);
        return ResponseEntity.ok(policy);
    }

    @GetMapping("/preview/policies")
    public ResponseEntity<?> getPolicies() {
        Iterable<Policy> policy = policyService.getPolicies();
        return ResponseEntity.ok(policy);
    }

    @GetMapping("/chainOfProvider")
    public ResponseEntity<?> getChainOfProvider(@RequestParam Integer policyNumber) {
        Iterable<Providers> providers = policyService.getChainOfProvider(policyNumber);
        return ResponseEntity.ok(providers);
    }

    @GetMapping("/viewChainOfProvider")
    public ResponseEntity<?> chainOfProvider() {
        Iterable<Providers> providers = policyService.getChainOfProvider();
        return ResponseEntity.ok(providers);
    }

    @GetMapping("/elligibleProviderBenifits")
    public ResponseEntity<?> getElligibleBenifits(@RequestParam Integer id) {
        Iterable<ProviderBenefits> benefits = policyService.getElligibleBenifits(id);
        return ResponseEntity.ok(benefits);
    }

    @PostMapping("/enrolPolicy")
    public ResponseEntity<?> enrolPolicy(@RequestBody MemberPolicyRequest request) {
        MemberPolicy memberPolicy = policyService.enrolPolicy(request);
        return ResponseEntity.ok(memberPolicy);
    }

    @GetMapping("/viewBills")
    public ResponseEntity<?> viewBills(@RequestParam Integer memberId) {
        List<Bills> bills = policyService.viewBills(memberId);
        return ResponseEntity.ok(bills);
    }
}
