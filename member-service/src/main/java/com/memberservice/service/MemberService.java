package com.memberservice.service;

import com.memberservice.entity.Bills;
import com.memberservice.entity.MemberPolicy;
import com.memberservice.model.MemberPolicyRequest;
import com.memberservice.repository.BillRepository;
import com.memberservice.repository.MemberPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class MemberService {

    @Autowired
    MemberPolicyRepository memberPolicyRepository;

    @Autowired
    BillRepository billRepository;



    public MemberPolicy enrolPolicy(MemberPolicyRequest request) {
        LocalDate policyStartDate = request.getSubscriptionDate();
        LocalDate nextPremiumDate = policyStartDate.plusYears(1l);
        LocalDate premiumDueDate = policyStartDate.plusYears(1l).plusDays(15l);
        MemberPolicy memberPolicy = new MemberPolicy();
        memberPolicy.setMemberId(request.getMemberId());
        memberPolicy.setPolicyNumber(request.getPolicyNumber());
        memberPolicy.setPolicyName(request.getPolicyName());
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
