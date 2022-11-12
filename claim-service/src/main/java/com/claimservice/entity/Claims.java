package com.claimservice.entity;

import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Claims {

    @Id
    private Double claimId;

    private Integer policyNumber;
    private String policyName;
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

    public Claims(Double claimId, Integer policyNumber, String policyName, Integer memberId, Integer providerId, String providerName, String benefitsAvailed, BigDecimal billAmount, BigDecimal claimAmount, LocalDate claimDate, String claimStatus) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.policyName = policyName;
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

    public Double getClaimId() {
        return claimId;
    }

    public void setClaimId(Double claimId) {
        this.claimId = claimId;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
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
