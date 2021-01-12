package com.rule.violation.details.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rule.violation.details.model.ViolationDTO;
import com.rule.violation.details.model.ViolationVehicleDTO;
import com.rule.violation.details.repository.VehicleVioltnDtlnRepository;
import com.rule.violation.details.repository.ViolationVehicleRepository;

@Service
public class VehicleVioltnDtlsService {

	@Autowired
	VehicleVioltnDtlnRepository violtnDtlnRepository;
	
	@Autowired
	ViolationVehicleRepository violationVehicleRepository;
	
	public ViolationVehicleDTO getViolationVehicle(String id) {
		if(violationVehicleRepository.findById(id).isPresent())
		return violationVehicleRepository.findById(id).get();
		return null;
	}
	
	public ViolationDTO getViolationDtls(int id) {
		if(violtnDtlnRepository.findById(id).isPresent())
		return violtnDtlnRepository.findById(id).get();
		return null;
	}
	
	public List<ViolationVehicleDTO> findByVioltedVehicleNumber(String violtedVehicleNumber) {
		if(null!=violationVehicleRepository.findByVioltedVehicleNumber(violtedVehicleNumber))
		return violationVehicleRepository.findByVioltedVehicleNumber(violtedVehicleNumber);
		return null;
	}
	
	
}
