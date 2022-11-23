package com.policyservice.service;

import com.policyservice.entity.MemberPolicy;
import com.policyservice.entity.Policy;
import com.policyservice.entity.Providers;
import com.policyservice.model.MemberPolicyRequest;
import com.policyservice.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PolicyServiceTest {

    @InjectMocks
    PolicyService policyService;

    @Mock
    PolicyRepository policyRepository;

    @Mock
    ProvidersRepository providersRepository;

    @Mock
    BenefitsRepository benefitsRepository;

    @Mock
    MemberPolicyRepository memberPolicyRepository;

    @Mock
    BillRepository billRepository;

    @Test
    public void getPolicyTest() {
        Policy policy = new Policy();
        policy.setPolicyNumber(1234);
        policy.setPolicyName("name");
        Mockito.when(policyRepository.findById(1234)).thenReturn(Optional.of(policy));
        Assert.assertNotNull(policyService.getPolicy(1234));
    }

    @Test
    public void getPoliciesTest() {
        Iterable<Policy> policies = new ArrayList<>();
        Policy policy = new Policy();
        policy.setPolicyNumber(1234);
        policy.setPolicyName("name");
        ((ArrayList<Policy>) policies).add(policy);
        Mockito.when(policyRepository.findAll()).thenReturn(policies);
        Assert.assertNotNull(policyService.getPolicies());
    }

    @Test
    public void getChainOfProviderTest() {
        Iterable<Providers> providerList = new ArrayList<>();
        Providers providers = new Providers();
        providers.setPolicyNumber(1234);
        providers.setProviderLocation("blr");
        providers.setProviderData("data");
        ((ArrayList<Providers>) providerList).add(providers);
        Mockito.when(providersRepository.findAll()).thenReturn(providerList);
        Assert.assertNotNull(policyService.getChainOfProvider());
    }

    @Test
    public void enrolPolicyTest() {
        Policy policy = new Policy();
        policy.setPolicyNumber(1234);
        policy.setPolicyName("name");
        Mockito.when(policyRepository.findById(1234)).thenReturn(Optional.of(policy));
        MemberPolicyRequest request = new MemberPolicyRequest();
        LocalDate localDate = LocalDate.now();
        request.setCoverage(new BigDecimal(1234));
        request.setMemberId(1234);
        request.setPolicyName("abc");
        request.setPolicyNumber(1234);
        request.setPremiumAmount(new BigDecimal(123));
        request.setSubscriptionDate(localDate);

        LocalDate policyStartDate = request.getSubscriptionDate();

        List<MemberPolicy> memberPolicyList = new ArrayList<>();
        MemberPolicy memberPolicy = new MemberPolicy();
        memberPolicy.setMemberId(request.getMemberId());
        memberPolicy.setPolicyNumber(request.getPolicyNumber());
        memberPolicy.setPolicyName(request.getPolicyName());
        memberPolicy.setSubscriptionDate(policyStartDate);
        memberPolicy.setCoverage(request.getCoverage());
        memberPolicy.setPremiumAmount(request.getPremiumAmount());
        memberPolicy.setPremiumPaidtDate(policyStartDate);
        memberPolicyList.add(memberPolicy);
        Mockito.when(memberPolicyRepository.findByMemberId(1234)).thenReturn(memberPolicyList);

        Assert.assertNull(policyService.enrolPolicy(request));
    }



}
