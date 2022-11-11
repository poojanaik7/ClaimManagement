package com.policyservice.repository;

import com.policyservice.entity.Benefits;
import com.policyservice.entity.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitsRepository extends CrudRepository<Benefits, Integer> {

    public List<Benefits> findByProviderId(Integer policyNumber);

}
