package com.claimservice.model;

import java.util.List;

public class Policy {

    private Integer policyNumber;
    private String policyName;
    private List<Premium> premium;
    private List<Providers> providers ;
    private List<PolicyBenefits> policyBenefits;

    public Policy() {
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

    public List<Premium> getPremium() {
        return premium;
    }

    public void setPremium(List<Premium> premium) {
        this.premium = premium;
    }

    public List<Providers> getProviders() {
        return providers;
    }

    public void setProviders(List<Providers> providers) {
        this.providers = providers;
    }

    public List<PolicyBenefits> getPolicyBenefits() {
        return policyBenefits;
    }

    public void setPolicyBenefits(List<PolicyBenefits> policyBenefits) {
        this.policyBenefits = policyBenefits;
    }
}