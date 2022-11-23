package com.memberservice.controller;

import com.memberservice.entity.MemberPolicy;
import com.memberservice.model.BillsResponse;
import com.memberservice.model.LoginRequest;
import com.memberservice.model.SignupRequest;
import com.memberservice.repository.MemberRepository;
import com.memberservice.security.jwt.JwtUtils;
import com.memberservice.security.services.UserDetailsImpl;
import com.memberservice.service.MemberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {

    @InjectMocks
    MemberController memberController;

    @Mock
    MemberRepository repository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    JwtUtils jwtUtils;

    @Mock
    Authentication authentication;

    @Mock
    RestTemplate restTemplate;

    @Mock
    MemberService memberService;

    @Test
    public void authenticateUserTest() {
        LoginRequest request = new LoginRequest();
        request.setUsername("pnaik");
        request.setPassword("fd74");
        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_MEMBER";
            }
        };
        authorities.add(grantedAuthority);
        UserDetailsImpl userDetails = new UserDetailsImpl(1, "pnaik", "pnaik@g.com", "7584djj");
        Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(authentication);
        Mockito.when(jwtUtils.generateJwtToken(Mockito.any())).thenReturn("54gdfgdg837");
        Mockito.when(authentication.getPrincipal()).thenReturn(userDetails);
        ResponseEntity<?> responseEntity = memberController.authenticateUser(request);
        org.junit.Assert.assertNotNull(responseEntity);
    }

    @Test
    public void registerReaderTest() {
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail("pnaik@1.com");
        signupRequest.setUsername("pnaik");
        signupRequest.setPassword("abcd");
        signupRequest.setAddress("Bangalore");
        signupRequest.setContactNumber(99999);
        signupRequest.setDob(new Date());
        Mockito.when(repository.existsByEmail("pnaik@1.com")).thenReturn(false);
        Mockito.when(repository.existsByName("pnaik")).thenReturn(false);
        Mockito.when(passwordEncoder.encode(signupRequest.getPassword())).thenReturn("64767647fhdgffh");
        ResponseEntity<?> responseEntity = memberController.registerUser(signupRequest);
        Assert.assertNotNull(responseEntity);
    }

    @Test
    public void enrollPolicyTest() {
        MemberPolicy memberPolicy = new MemberPolicy();
        memberPolicy.setCoverage(new BigDecimal(1233));
        memberPolicy.setMemberId(123);
        memberPolicy.setPolicyName("abc");
        memberPolicy.setPolicyNumber(123);
        memberPolicy.setPremiumAmount(new BigDecimal(123));
        Mockito.when(memberService.enrolPolicy(Mockito.any())).thenReturn(memberPolicy);
        ResponseEntity<?> responseEntity = memberController.enrolPolicy(Mockito.any());
        Assert.assertNotNull(responseEntity);
    }

    @Test
    public void claimStatusrTest() {
        Mockito.when(restTemplate.getForObject("http://CLAIM-SERVICE/claims/claimStatus",String.class)).thenReturn("Action Pending");
        String claimStatus = memberController.getClaimStatus();
        Assert.assertNotNull(claimStatus);
    }
}