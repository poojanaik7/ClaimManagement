package com.claimservice.service;

import com.claimservice.entity.Claims;
import com.claimservice.repository.ClaimsRepository;
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
public class ClaimServiceTest {

    @InjectMocks
    ClaimsService claimsService;

    @Mock
    ClaimsRepository claimsRepository;

    @Test
    public void getClaimStatus() {
        Iterable<Claims> claimsIterable = new ArrayList<>();
        Claims claims = new Claims();
        claims.setBenefitsAvailed("benefit");
        claims.setBillAmount(new BigDecimal(1000));
        claims.setClaimAmount(new BigDecimal(1000));
        claims.setClaimStatus("Pending Action");
        ((ArrayList<Claims>) claimsIterable).add(claims);
        Mockito.when(claimsRepository.findAll()).thenReturn(claimsIterable);
        Assert.assertNotNull(claimsService.viewClaimStatus(12345));
    }
}
