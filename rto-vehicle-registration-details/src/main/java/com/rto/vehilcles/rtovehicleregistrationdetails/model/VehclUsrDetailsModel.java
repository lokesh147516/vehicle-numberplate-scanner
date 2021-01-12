package com.rto.vehilcles.rtovehicleregistrationdetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehclUsrDetailsModel {
	private String numberPlate;
	private String vehicleName;
	private String vehicleManufacturer;
	private String vehicleOrgnlColor;

	private String ownerName;

}
