package com.violation.mail.mailingservice.services;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.violation.mail.mailingservice.model.OwnerDTO;
import com.violation.mail.mailingservice.model.VehclUsrDetailsModel;
import com.violation.mail.mailingservice.model.VehicleDTO;

@FeignClient(contextId="rtoDtls",  name="netflix-zuul-api-gateway-server")
@RibbonClient(name="rto-vehicle-registration-details")
@Service
public interface RtoVehicleDtlsServiceInterface {

	@GetMapping("/rto-vehicle-registration-details/heelo")
	public String hello() ;
	
	@GetMapping("/rto-vehicle-registration-details/owners-details")
	public List<OwnerDTO> getOwnerDetails();
	
	@GetMapping("/rto-vehicle-registration-details/owner-details/{id}")
	public OwnerDTO getOwnerDetail(@PathVariable(name="id") String id);
	
	@GetMapping("/rto-vehicle-registration-details/vehicle-details/{id}")
	public VehicleDTO getVehicleDetail(@PathVariable(name="id") String id);

	@GetMapping("/rto-vehicle-registration-details/vehicle-usr-details/{id}")
	public VehclUsrDetailsModel getVehicleUsrDetail(@PathVariable(name="id") String id);
	
	
	
}
