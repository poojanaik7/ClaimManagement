package com.policyservice.repository;

import com.policyservice.entity.Providers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvidersRepository extends CrudRepository<Providers, Integer> {

    public List<Providers> findByPolicyNumber(Integer policyNumber);

}
