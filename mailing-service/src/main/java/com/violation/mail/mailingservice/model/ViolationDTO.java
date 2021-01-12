package com.violation.mail.mailingservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViolationDTO {
	private int ruleVioltedId;
	private String violationName;
	private String violationType;
	private double fineAmt;
	private List<ViolationVehicleDTO> violationVehicleDTO;

}
