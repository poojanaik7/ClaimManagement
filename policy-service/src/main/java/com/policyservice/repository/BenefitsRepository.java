package com.policyservice.repository;

import com.policyservice.entity.ProviderBenefits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitsRepository extends CrudRepository<ProviderBenefits, Integer> {

    public List<ProviderBenefits> findByProviderId(Integer policyNumber);

}
