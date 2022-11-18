package com.policyservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "premium")
public class Premium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private BigDecimal coverage;

    @NotNull
    private BigDecimal premiumAmount;

    @NotNull
    private String premiumPaymentFrequency;

    @NotNull
    @Column(name = "policy_number")
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

    public String getPremiumPaymentFrequency() {
        return premiumPaymentFrequency;
    }

    public void setPremiumPaymentFrequency(String premiumPaymentFrequency) {
        this.premiumPaymentFrequency = premiumPaymentFrequency;
    }
}
