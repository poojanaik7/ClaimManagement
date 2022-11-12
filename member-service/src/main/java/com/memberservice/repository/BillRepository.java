package com.memberservice.repository;

import com.memberservice.entity.Bills;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bills, Integer> {

    public List<Bills> findByMemberId(Integer memberId);
}
