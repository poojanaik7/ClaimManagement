package com.policyservice.service;

import com.policyservice.entity.*;
import com.policyservice.model.MemberPolicyRequest;
import com.policyservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PolicyService {
    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    ProvidersRepository providersRepository;

    @Autowired
    BenefitsRepository benefitsRepository;

    @Autowired
    MemberPolicyRepository memberPolicyRepository;

    @Autowired
    BillRepository billRepository;

    public Policy getPolicy(Integer policyNumber) {
        return policyRepository.findById(policyNumber).get();
    }

    public Iterable<Policy> getPolicies() {
        return policyRepository.findAll();
    }

    public Iterable<Providers> getChainOfProvider(Integer policyNumber) {
        return providersRepository.findByPolicyNumber(policyNumber);
    }

    public Iterable<Providers> getChainOfProvider() {
        return providersRepository.findAll();
    }

    public Iterable<ProviderBenefits> getElligibleBenifits(Integer id) {
        return benefitsRepository.findByProviderId(id);
    }

    public MemberPolicy enrolPolicy(MemberPolicyRequest request) {
        Policy policy = policyRepository.findById(request.getPolicyNumber()).get();
        LocalDate policyStartDate = request.getSubscriptionDate();
        LocalDate nextPremiumDate = policyStartDate.plusYears(1l);
        LocalDate premiumDueDate = policyStartDate.plusYears(1l).plusDays(15l);
        MemberPolicy memberPolicy = new MemberPolicy();
        memberPolicy.setMemberId(request.getMemberId());
        memberPolicy.setPolicyNumber(request.getPolicyNumber());
        memberPolicy.setPolicyName(policy.getPolicyName());
        memberPolicy.setSubscriptionDate(policyStartDate);
        memberPolicy.setCoverage(request.getCoverage());
        memberPolicy.setPremiumAmount(request.getPremiumAmount());
        memberPolicy.setPremiumPaidtDate(policyStartDate);
        MemberPolicy memPolicy = memberPolicyRepository.save(memberPolicy);
        if(Objects.nonNull(memberPolicy)){
            billRepository.save(new Bills(memberPolicy.getPolicyNumber(),memberPolicy.getPremiumPaidtDate(),premiumDueDate,1,memberPolicy.getPremiumAmount(),memberPolicy.getCoverage(),nextPremiumDate,memberPolicy.getMemberId()));
        }
        return memPolicy;
    }

    public List<Bills> viewBills(Integer memberId){
        return billRepository.findByMemberId(memberId);
    }
}