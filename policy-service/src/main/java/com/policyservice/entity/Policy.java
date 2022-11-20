package com.policyservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "policy")
public class Policy {

    @Id
    @Column(name = "policy_number")
    private Integer policyNumber;

    @NotNull
    private String policyName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_number", referencedColumnName = "policy_number")
    private List<Premium> premium = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_number", referencedColumnName = "policy_number")
    private List<Providers> providers = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_number", referencedColumnName = "policy_number")
    private List<PolicyBenefits> policyBenefits = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_number", referencedColumnName = "policy_number")
    private List<TopUp> topUp;

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

    public List<TopUp> getTopUp() {
        return topUp;
    }

    public void setTopUp(List<TopUp> topUp) {
        this.topUp = topUp;
    }
}