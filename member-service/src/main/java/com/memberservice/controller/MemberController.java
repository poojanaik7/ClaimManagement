package com.memberservice.controller;


import com.memberservice.entity.Member;
import com.memberservice.entity.MemberPolicy;
import com.memberservice.model.*;
import com.memberservice.repository.MemberRepository;
import com.memberservice.security.jwt.JwtUtils;
import com.memberservice.security.services.UserDetailsImpl;
import com.memberservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MemberService memberService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail()));

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (memberRepository.existsByName(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (memberRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Member user = new Member(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getContactNumber(),
                signUpRequest.getAddress(),
                signUpRequest.getDob()
        );

        memberRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping("/claimStatus")
    public String getClaimStatus() {
        String status = restTemplate.getForObject("http://CLAIM-SERVICE/claims/claimStatus", String.class);
        return status;
    }

    @PostMapping("/enrolPolicy")
    public ResponseEntity<?> enrolPolicy(@RequestBody MemberPolicyRequest request) {
        MemberPolicy memberPolicy = memberService.enrolPolicy(request);
        return ResponseEntity.ok(memberPolicy);
    }

    @RequestMapping(value = "/viewBills", method = RequestMethod.GET, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> viewBills(@RequestParam Integer memberId) {
        Map<String, Integer> params = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        params.put("memberId", memberId);
        ResponseEntity<?> response = restTemplate.exchange("http://POLICY-SERVICE/policy/viewBills?memberId={memberId}", HttpMethod.GET, entity, new ParameterizedTypeReference<List<BillsResponse>>() {
        }, memberId);
        return response;
    }

    @RequestMapping(value = "/submitClaim", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> submitClaim(@RequestBody ClaimsRequest claimsRequest) {
        Claims claims = restTemplate.postForObject("http://CLAIM-SERVICE/claims/submitClaim", claimsRequest, Claims.class);
        return ResponseEntity.ok(claims);
    }
}
