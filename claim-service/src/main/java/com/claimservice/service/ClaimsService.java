package com.claimservice.service;

import com.claimservice.entity.Claims;
import com.claimservice.model.*;
import com.claimservice.repository.ClaimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClaimsService {

    @Autowired
    ClaimsRepository claimsRepository;

    @Autowired
    RestTemplate restTemplate;

    public Claims submitClaims(ClaimsRequest request) {
        UUID claimId = UUID.randomUUID();
        Map<String, Integer> policyParams = new HashMap<>();
        Map<String, Integer> params = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        params.put("memberId",request.getMemberId());
        ResponseEntity<List<Bills>> response = restTemplate.exchange("http://POLICY-SERVICE/policy/viewBills?memberId={memberId}", HttpMethod.GET,entity, new ParameterizedTypeReference<List<Bills>>() {},params);
        Integer policyNumber = response.getBody().get(0).getPolicyNumber();
        policyParams.put("policyNumber",policyNumber);
        ResponseEntity<Policy> policyResponseEntity = restTemplate.exchange("http://POLICY-SERVICE/policy/viewPolicy?policyNumber={policyNumber}", HttpMethod.GET,entity, Policy.class,policyParams);
        String status = isApplicable(policyResponseEntity.getBody(),request,response.getBody().get(0));

        Claims claims = new Claims(claimId,request.getPolicyNumber(),request.getMemberId(),request.getProviderId(),
                request.getProviderName(),request.getBenefitsAvailed(),request.getBillAmount(),request.getClaimAmount(),request.getClaimDate(),status);
        Claims claim = claimsRepository.save(claims);


        return claim;
    }

    public String isApplicable(Policy policy,ClaimsRequest request,Bills billResponse){
        String status = null;
        List<PolicyBenefits> benefits= policy.getPolicyBenefits();
        List<PolicyBenefits> availedBenefits = benefits.stream().filter(benefit -> request.getBenefitsAvailed().equals(benefit.getBenefitName())).collect(Collectors.toList());

        Integer val = request.getClaimAmount().compareTo(billResponse.getCoverage());
        if((val != 1) && Objects.nonNull(availedBenefits)){
            status = "Pending Action";
        }else{
            status = "Claim Rejected";
        }
        return  status;
    }

    public Iterable<Claims> viewClaimStatus(){
       return claimsRepository.findAll();
    }
}
