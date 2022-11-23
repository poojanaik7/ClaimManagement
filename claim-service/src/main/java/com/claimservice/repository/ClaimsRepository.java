package com.claimservice.repository;

import com.claimservice.entity.Claims;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimsRepository extends CrudRepository<Claims, Integer> {

    public List<Claims> findByMemberId(Integer memberId);
}
