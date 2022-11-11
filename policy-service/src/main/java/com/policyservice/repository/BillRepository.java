package com.policyservice.repository;

import com.policyservice.entity.Benefits;
import com.policyservice.entity.Bills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bills, Integer> {

    public List<Bills> findByMemberId(Integer memberId);
}
