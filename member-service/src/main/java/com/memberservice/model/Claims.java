package com.memberservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Claims {


    private Integer claimId;
    private Integer policyNumber;
    private Integer memberId;
    private Integer providerId;
    private String providerName;
    private String benefitsAvailed;
    private BigDecimal billAmount;
    private BigDecimal claimAmount;
    private LocalDate claimDate;
    private String claimStatus;

    public Claims() {
    }

    public Claims(Integer policyNumber, Integer memberId, Integer providerId, String providerName, String benefitsAvailed, BigDecimal billAmount, BigDecimal claimAmount, LocalDate claimDate, String claimStatus) {
        this.policyNumber = policyNumber;
        this.memberId = memberId;
        this.providerId = providerId;
        this.providerName = providerName;
        this.benefitsAvailed = benefitsAvailed;
        this.billAmount = billAmount;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
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

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getBenefitsAvailed() {
        return benefitsAvailed;
    }

    public void setBenefitsAvailed(String benefitsAvailed) {
        this.benefitsAvailed = benefitsAvailed;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(BigDecimal claimAmount) {
        this.claimAmount = claimAmount;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }
}
