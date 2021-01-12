package com.rule.violation.details.model;

import java.util.Date;


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
