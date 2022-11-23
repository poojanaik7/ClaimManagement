package com.claimservice.controller;

import com.claimservice.entity.Claims;
import com.claimservice.model.ClaimsRequest;
import com.claimservice.service.ClaimsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class ClaimControllerTest {

    @InjectMocks
    ClaimController claimController;

    @Mock
    ClaimsService claimsService;

    @Test
    public void submitClaim(){
        ClaimsRequest claimsRequest = new ClaimsRequest();
        Claims claims =new Claims();
        claims.setBenefitsAvailed("benefit");
        claims.setBillAmount(new BigDecimal(1000));
        claims.setClaimAmount(new BigDecimal(1000));
        claims.setClaimStatus("Pending Action");
        claimsRequest.setBenefitsAvailed("benefits");
        claimsRequest.setBillAmount(new BigDecimal(1000));
        claimsRequest.setClaimAmount(new BigDecimal(1000));
        Mockito.when(claimsService.submitClaims(claimsRequest)).thenReturn(claims);
        Assert.assertNotNull(claimController.submitClaim(claimsRequest));
    }

    @Test
    public void getClaimStatus(){
        Iterable<Claims> claimsIterable = new ArrayList<>();
        Claims claims =new Claims();
        claims.setBenefitsAvailed("benefit");
        claims.setBillAmount(new BigDecimal(1000));
        claims.setClaimAmount(new BigDecimal(1000));
        claims.setClaimStatus("Pending Action");
        ((ArrayList<Claims>) claimsIterable).add(claims);
        Mockito.when(claimsService.viewClaimStatus(1234)).thenReturn(claimsIterable);
        Assert.assertNotNull(claimController.getClaimStatus(1234));
    }
}
