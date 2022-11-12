package com.claimservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class Premium {


    private Integer id;

    private BigDecimal coverage;

    private BigDecimal premiumAmount;

    private Integer premiumPaymentFrequency;

    private Integer policyNumber;

    public Premium() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
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

    public Integer getPremiumPaymentFrequency() {
        return premiumPaymentFrequency;
    }

    public void setPremiumPaymentFrequency(Integer premiumPaymentFrequency) {
        this.premiumPaymentFrequency = premiumPaymentFrequency;
    }
}
