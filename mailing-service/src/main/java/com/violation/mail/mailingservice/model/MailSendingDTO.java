package com.violation.mail.mailingservice.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailSendingDTO {
	private String numberPlate;
	private String vehicleName;
	private String vehicleManufacturer;
	private String vehicleOrgnlColor;
	private String ownerName;
	
	
	private String violtedVehicleNumber;
	private String violatedDate;
	
	private String violationName;
	private double fineAmt;
	
}
