package com.rto.vehilcles.rtovehicleregistrationdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rto.vehilcles.rtovehicleregistrationdetails.exception.OwnerNotFoundException;
import com.rto.vehilcles.rtovehicleregistrationdetails.exception.VehilceNotFoundException;
import com.rto.vehilcles.rtovehicleregistrationdetails.model.OwnerDTO;
import com.rto.vehilcles.rtovehicleregistrationdetails.model.VehclUsrDetailsModel;
import com.rto.vehilcles.rtovehicleregistrationdetails.model.VehicleDTO;
import com.rto.vehilcles.rtovehicleregistrationdetails.service.RtoVehicleRegDetailsService;

@RestController
public class RtoVehicleRegDetailsController {

	@Autowired
	private RtoVehicleRegDetailsService rtoVehicleRegDetailsService;

	@GetMapping("/heelo")
	public String hello() {
		return "hello";
	}

	@GetMapping("/owners-details")
	public List<OwnerDTO> getOwnerDetails() {
		if (null != rtoVehicleRegDetailsService.getOwnerDTOs())
			return rtoVehicleRegDetailsService.getOwnerDTOs();
		throw new OwnerNotFoundException("Owner Details not found");
	}

	@GetMapping("/owner-details/{id}")
	public OwnerDTO getOwnerDetail(@PathVariable String id) {
		if (null != rtoVehicleRegDetailsService.getOwnerDetail(id))
			return rtoVehicleRegDetailsService.getOwnerDetail(id);
		throw new OwnerNotFoundException("Owner Details not found");
	}

	@GetMapping("/vehicle-details/{id}")
	public VehicleDTO getVehicleDetail(@PathVariable String id) {
		if (null != rtoVehicleRegDetailsService.getVehicleDetailById(id))
			return rtoVehicleRegDetailsService.getVehicleDetailById(id);
		throw new VehilceNotFoundException("Vehicle details not found");
	}
	
	@GetMapping("/vehicle-usr-details/{id}")
	public VehclUsrDetailsModel getVehicleUsrDetail(@PathVariable String id) {
		if (null != rtoVehicleRegDetailsService.getVehicleDetailById(id)) {
			 VehicleDTO dto=rtoVehicleRegDetailsService.getVehicleDetailById(id);
			 VehclUsrDetailsModel model=new VehclUsrDetailsModel();
			 model.setNumberPlate(dto.getNumberPlate());
			 model.setOwnerName(dto.getOwner().getOwnerName());
			 model.setVehicleManufacturer(dto.getVehicleManufacturer());
			 model.setVehicleName(dto.getVehicleName());
			 model.setVehicleOrgnlColor(dto.getVehicleOrgnlColor());
			 return model;
		}
		throw new VehilceNotFoundException("Vehicle details not found");
	}
	

}
