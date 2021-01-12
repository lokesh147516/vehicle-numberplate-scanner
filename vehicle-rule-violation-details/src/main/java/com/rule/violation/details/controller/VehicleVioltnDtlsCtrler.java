package com.rule.violation.details.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rule.violation.details.exception.VehicleNotPresentException;
import com.rule.violation.details.exception.ViolationException;
import com.rule.violation.details.model.ViolatdVehclModel;
import com.rule.violation.details.model.ViolationDTO;
import com.rule.violation.details.model.ViolationVehicleDTO;
import com.rule.violation.details.service.VehicleVioltnDtlsService;

@RestController
public class VehicleVioltnDtlsCtrler {
	@Autowired
	VehicleVioltnDtlsService service;

	@GetMapping("/test")
	public String getTest() {
		return "raam";
	}
	
	@GetMapping("/ViolationVehicle/{id}")
	public ViolationVehicleDTO getViolationVehicle(@PathVariable String id) { 
		if(null!=service.getViolationVehicle(id))
		return service.getViolationVehicle(id);
	throw new VehicleNotPresentException("vehicle details are not present");
	}
	@GetMapping("/ViolationDtls/{id}")
	public ViolationDTO getViolationDtls(@PathVariable int id) {
		if(null!=service.getViolationDtls(id))
		return service.getViolationDtls(id);
	throw new ViolationException("No Violation Found");
	}
	
	@GetMapping("/vehicleDtls/{violtedVehicleNumber}")
	public List<ViolationVehicleDTO> findByVioltedVehicleNumber(@PathVariable String violtedVehicleNumber) {
		if(null!=service.findByVioltedVehicleNumber(violtedVehicleNumber))
		return service.findByVioltedVehicleNumber(violtedVehicleNumber);
		throw new VehicleNotPresentException("vehicle details are not present");
	}

	@GetMapping("/vehicleVioledDtls/{violtedVehicleNumber}")
	public List<ViolatdVehclModel> findByVehicleNumber(@PathVariable String violtedVehicleNumber) {
		List<ViolatdVehclModel> vehclModels=new ArrayList<ViolatdVehclModel>();
		if(null!=service.findByVioltedVehicleNumber(violtedVehicleNumber)) {
			List<ViolationVehicleDTO> violationVehicleDTOs= service.findByVioltedVehicleNumber(violtedVehicleNumber);
			for (ViolationVehicleDTO violationVehicleDTO : violationVehicleDTOs) {
				ViolatdVehclModel vehclModel=new ViolatdVehclModel();
				vehclModel.setFineAmt(violationVehicleDTO.getViolationDTOs().getFineAmt());
				vehclModel.setViolatedDate(violationVehicleDTO.getViolatedDate());
				vehclModel.setViolationName(violationVehicleDTO.getViolationDTOs().getViolationName());
				vehclModel.setViolationType(violationVehicleDTO.getViolationDTOs().getViolationType());
				vehclModel.setVioltedVehicleNumber(violationVehicleDTO.getVioltedVehicleNumber());
				vehclModels.add(vehclModel);
			}
			return vehclModels;
		}
		
		throw new VehicleNotPresentException("vehicle details are not present");
	}
	
}
