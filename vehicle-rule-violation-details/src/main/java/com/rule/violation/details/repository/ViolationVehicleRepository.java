package com.rule.violation.details.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rule.violation.details.model.ViolationVehicleDTO;

@Repository
public interface ViolationVehicleRepository extends JpaRepository<ViolationVehicleDTO, String> {
	List<ViolationVehicleDTO> findByVioltedVehicleNumber(String violtedVehicleNumber);
}
