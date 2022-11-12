package com.claimservice.service;

import com.claimservice.entity.Claims;
import com.claimservice.model.ClaimsRequest;
import com.claimservice.model.Policy;
import com.claimservice.repository.ClaimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClaimsService {

    @Autowired
    ClaimsRepository claimsRepository;

    @Autowired
    RestTemplate restTemplate;

    public Claims submitClaims(ClaimsRequest request) {
        Double claimId = Math.random();

        Map<String, Integer> params = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        params.put("policyNumber",request.getPolicyNumber());
        ResponseEntity<Policy> response = restTemplate.exchange("http://POLICY-SERVICE/policy/viewPolicy?policyNumber={policyNumber}", HttpMethod.GET,entity, Policy.class,params);
        response.getBody();
        Claims claims = new Claims(claimId,request.getPolicyNumber(),request.getPolicyName(),request.getMemberId(),request.getProviderId(),
                request.getProviderName(),request.getBenefitsAvailed(),request.getBillAmount(),request.getClaimAmount(),request.getClaimDate(),);
        Claims claim = claimsRepository.save(claims);


        return claim;
    }
}
