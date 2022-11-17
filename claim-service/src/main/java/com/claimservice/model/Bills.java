package com.claimservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Bills {

    private Integer billId;

    private Integer memberId;

    private Integer policyNumber;

    private LocalDate premiumPaidDate;

    private LocalDate premiumDueDate;

    private Integer paymentTerm;

    private BigDecimal premiumAmount;

    private BigDecimal coverage;

    private LocalDate nextPremiumDate;

    public Bills(){

    }

    public Bills(Integer policyNumber, LocalDate premiumPaidDate, LocalDate premiumDueDate, Integer paymentTerm,
                 BigDecimal premiumAmount, BigDecimal coverage, LocalDate nextPremiumDate, Integer memberId) {
        this.policyNumber = policyNumber;
        this.premiumPaidDate = premiumPaidDate;
        this.premiumDueDate = premiumDueDate;
        this.paymentTerm = paymentTerm;
        this.premiumAmount = premiumAmount;
        this.coverage = coverage;
        this.nextPremiumDate = nextPremiumDate;
        this.memberId = memberId;
    }

    public LocalDate getNextPremiumDate() {
        return nextPremiumDate;
    }

    public void setNextPremiumDate(LocalDate nextPremiumDate) {
        this.nextPremiumDate = nextPremiumDate;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public LocalDate getPremiumPaidDate() {
        return premiumPaidDate;
    }

    public void setPremiumPaidDate(LocalDate premiumPaidDate) {
        this.premiumPaidDate = premiumPaidDate;
    }

    public LocalDate getPremiumDueDate() {
        return premiumDueDate;
    }

    public void setPremiumDueDate(LocalDate premiumDueDate) {
        this.premiumDueDate = premiumDueDate;
    }

    public Integer getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(Integer paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public BigDecimal getCoverage() {
        return coverage;
    }

    public void setCoverage(BigDecimal coverage) {
        this.coverage = coverage;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}
