package com.claimservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Providers {


    private Integer providerId;

    private String providerName;

    private String providerLocation;

    private Integer policyNumber;

    private String providerData;

    private List<ProviderBenefits> benefits;

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

    public List<ProviderBenefits> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<ProviderBenefits> benefits) {
        this.benefits = benefits;
    }
}
