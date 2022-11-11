package com.policyservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "providers")
public class Providers {

    @Id
    @Column(name = "provider_id")
    private Integer providerId;

    @NotNull
    private String providerName;

    @NotNull
    private String providerLocation;

    @NotNull
    @Column(name = "policy_number")
    private Integer policyNumber;

    private String providerData;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="provider_id" , referencedColumnName = "provider_id")
    private List<Benefits> benefits = new ArrayList<>();

    public Providers() {
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

    public String getProviderLocation() {
        return providerLocation;
    }

    public void setProviderLocation(String providerLocation) {
        this.providerLocation = providerLocation;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderData() {
        return providerData;
    }

    public void setProviderData(String providerData) {
        this.providerData = providerData;
    }

    public List<Benefits> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<Benefits> benefits) {
        this.benefits = benefits;
    }
}
