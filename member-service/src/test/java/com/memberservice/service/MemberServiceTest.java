package com.memberservice.service;

import com.memberservice.entity.Bills;
import com.memberservice.entity.MemberPolicy;
import com.memberservice.model.MemberPolicyRequest;
import com.memberservice.repository.BillRepository;
import com.memberservice.repository.MemberPolicyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @InjectMocks
    MemberService service;

    @Mock
    MemberPolicyRepository memberPolicyRepository;

    @Mock
    BillRepository billRepository;

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

        Bills bills = new Bills(memberPolicy.getPolicyNumber(),memberPolicy.getPremiumPaidtDate(),premiumDueDate,1,memberPolicy.getPremiumAmount(),memberPolicy.getCoverage(),nextPremiumDate,memberPolicy.getMemberId());

        Mockito.when(memberPolicyRepository.save(Mockito.any())).thenReturn(memberPolicy);
        Mockito.when(billRepository.save(Mockito.any())).thenReturn(bills);
        Assert.assertNotNull(service.enrolPolicy(request));
    }

}
