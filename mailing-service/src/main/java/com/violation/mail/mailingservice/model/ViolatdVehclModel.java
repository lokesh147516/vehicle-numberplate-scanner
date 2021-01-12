package com.violation.mail.mailingservice.model;

import java.util.Date;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViolatdVehclModel {

	private String violtedVehicleNumber;
	private Date violatedDate;
	
	private String violationName;
	private String violationType;
	private double fineAmt;
}
