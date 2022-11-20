package com.policyservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class TopUp {

    @Id
    private Integer topUpId;
    @Column(name="policy_number")
    private Integer policyNumber;
    @NotNull
    private BigDecimal coverage;

    private String topUpBenefit;

    @NotNull
    private BigDecimal premiumAmount;

    public Integer getTopUpId() {
        return topUpId;
    }

    public void setTopUpId(Integer topUpId) {
        this.topUpId = topUpId;
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

    public String getTopUpBenefit() {
        return topUpBenefit;
    }

    public void setTopUpBenefit(String topUpBenefit) {
        this.topUpBenefit = topUpBenefit;
    }
}
