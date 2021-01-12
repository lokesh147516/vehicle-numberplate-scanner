package com.violation.mail.mailingservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
	private String numberPlate;
	private String vehicleName;
	private String vehicleManufacturer;
	private String vehicleOrgnlColor;
	private int manufactureYear;
	private int soldYear;
	private OwnerDTO owner;
	private String rcNumber;
	private String chassisNum;
	private String engineNumber;
	private String fuelType;
	
	
}
