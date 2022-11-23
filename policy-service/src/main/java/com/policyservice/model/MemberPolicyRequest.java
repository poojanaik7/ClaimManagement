package com.policyservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MemberPolicyRequest {

    private Integer policyNumber;
    private String policyName;
    private Integer memberId;
    private BigDecimal coverage;
    private BigDecimal premiumAmount;
    private String premiumPaymentFrequency;
    private LocalDate subscriptionDate;
    private LocalDate dueDate;
    private BigDecimal topUpCoverage;
    private BigDecimal topUpPremiumAmount;

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getCoverage() {
        return coverage;
    }

    public void setCoverage(BigDecimal coverage) {
        this.coverage = coverage;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getPremiumPaymentFrequency() {
        return premiumPaymentFrequency;
    }

    public void setPremiumPaymentFrequency(String premiumPaymentFrequency) {
        this.premiumPaymentFrequency = premiumPaymentFrequency;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTopUpCoverage() {
        return topUpCoverage;
    }

    public void setTopUpCoverage(BigDecimal topUpCoverage) {
        this.topUpCoverage = topUpCoverage;
    }

    public BigDecimal getTopUpPremiumAmount() {
        return topUpPremiumAmount;
    }

    public void setTopUpPremiumAmount(BigDecimal topUpPremiumAmount) {
        this.topUpPremiumAmount = topUpPremiumAmount;
    }
}
