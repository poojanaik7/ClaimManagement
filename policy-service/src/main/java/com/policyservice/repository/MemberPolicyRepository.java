package com.policyservice.repository;

import com.policyservice.entity.MemberPolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberPolicyRepository extends CrudRepository<MemberPolicy, Integer> {

    public List<MemberPolicy> findByMemberId(Integer memberId);

}
