package com.claimservice.repository;

import com.claimservice.entity.Claims;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimsRepository extends CrudRepository<Claims, Integer> {

}
