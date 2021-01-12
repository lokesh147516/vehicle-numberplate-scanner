package com.violation.mail.mailingservice.services;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.violation.mail.mailingservice.model.ViolatdVehclModel;
import com.violation.mail.mailingservice.model.ViolationDTO;
import com.violation.mail.mailingservice.model.ViolationVehicleDTO;


@FeignClient(contextId="vehicleDtls", name="netflix-zuul-api-gateway-server")
@RibbonClient(name="vehicle-rule-violation-details")
@Service
public interface VehicleRuleViolnDtlsServiceInterface {

	@GetMapping("/vehicle-rule-violation-details/test")
	public String getTest();
	
	@GetMapping("/vehicle-rule-violation-details/ViolationVehicle/{id}")
	public ViolationVehicleDTO getViolationVehicle(@PathVariable(name="id") String id);
	@GetMapping("/vehicle-rule-violation-details/ViolationDtls/{id}")
	public ViolationDTO getViolationDtls(@PathVariable(name="id") int id) ;
	
	@GetMapping("/vehicle-rule-violation-details/vehicleDtls/{violtedVehicleNumber}")
	public List<ViolationVehicleDTO> findByVioltedVehicleNumber(@PathVariable(name="violtedVehicleNumber") String violtedVehicleNumber);
	
	@GetMapping("/vehicle-rule-violation-details/vehicleVioledDtls/{violtedVehicleNumber}")
	public List<ViolatdVehclModel> findByVehicleNumber(@PathVariable(name="violtedVehicleNumber") String violtedVehicleNumber) ;

	
}
