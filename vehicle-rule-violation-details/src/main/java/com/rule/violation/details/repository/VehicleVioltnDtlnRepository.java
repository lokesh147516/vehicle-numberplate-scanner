package com.rule.violation.details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rule.violation.details.model.ViolationDTO;

@Repository
public interface VehicleVioltnDtlnRepository extends JpaRepository<ViolationDTO, Integer>{
	
}
