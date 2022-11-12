package com.memberservice.repository;

import com.memberservice.entity.MemberPolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPolicyRepository extends CrudRepository<MemberPolicy, Integer> {


}
