package com.policyservice.controller;

import com.policyservice.entity.MemberPolicy;
import com.policyservice.entity.Policy;
import com.policyservice.entity.ProviderBenefits;
import com.policyservice.entity.Providers;
import com.policyservice.model.MemberPolicyRequest;
import com.policyservice.service.PolicyService;
import org.antlr.stringtemplate.language.ArrayIterator;
import org.bouncycastle.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PolicyControllerTest {

    @InjectMocks
    PolicyController policyController;

    @Mock
    PolicyService policyService;

    @Test
    public void getPolicyTest() {
        Policy policy = new Policy();
        policy.setPolicyName("abc");
        policy.setPolicyNumber(1234);
        Mockito.when( policyService.getPolicy(1234)).thenReturn(policy);
        Assert.assertNotNull(policyController.getPolicy(1234));
    }

    @Test
    public void getPoliciesTest() {
        Policy policy = new Policy();
        policy.setPolicyName("abc");
        policy.setPolicyNumber(1234);
        Iterable<Policy> policyList = new ArrayList<>();
        ((ArrayList<Policy>) policyList).add(policy);
        Mockito.when(policyService.getPolicies()).thenReturn(policyList);
        Assert.assertNotNull(policyController.getPolicies());
    }

    @Test
    public void chainOfProviderTest() {
        Providers providers = new Providers();
        providers.setPolicyNumber(1234);
        providers.setProviderData("data");
        providers.setProviderLocation("blr");
        Iterable<Providers> providerList = new ArrayList<>();
        ((ArrayList<Providers>) providerList).add(providers);
        Mockito.when(policyService.getChainOfProvider()).thenReturn(providerList);
        Assert.assertNotNull(policyController.chainOfProvider());
    }

    @Test
    public void getElligibleBenifitsTest() {
        Iterable<ProviderBenefits> benefits = new ArrayList<>();
        ProviderBenefits providerBenefits = new ProviderBenefits();
        providerBenefits.setBenefitId(1234);
        providerBenefits.setFacility("facility");
        providerBenefits.setProviderId(1234);
        providerBenefits.setSpeciality("speciality");
        ((ArrayList<ProviderBenefits>) benefits).add(providerBenefits);
        Mockito.when(policyService.getElligibleBenifits(1234)).thenReturn(benefits);
        Assert.assertNotNull(policyController.getElligibleBenifits(1234));
    }

    @Test
    public void enrolPolicyTest() {
        MemberPolicyRequest request = new MemberPolicyRequest();
        LocalDate localDate = LocalDate.now();
        request.setCoverage(new BigDecimal(123));
        request.setMemberId(123);
        request.setPolicyName("abc");
        request.setPolicyNumber(123);
        request.setPremiumAmount(new BigDecimal(123));
        request.setSubscriptionDate(localDate);

        LocalDate policyStartDate = request.getSubscriptionDate();

        MemberPolicy memberPolicy = new MemberPolicy();
        memberPolicy.setMemberId(request.getMemberId());
        memberPolicy.setPolicyNumber(request.getPolicyNumber());
        memberPolicy.setPolicyName(request.getPolicyName());
        memberPolicy.setSubscriptionDate(policyStartDate);
        memberPolicy.setCoverage(request.getCoverage());
        memberPolicy.setPremiumAmount(request.getPremiumAmount());
        memberPolicy.setPremiumPaidtDate(policyStartDate);
        Mockito.when(policyService.enrolPolicy(request)).thenReturn(memberPolicy);
        Assert.assertNotNull(policyController.enrolPolicy(request));
    }
}
