package com.violation.mail.mailingservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViolationVehicleDTO {

	private String violtdId;
	private String violtedVehicleNumber;
	private Date violatedDate;
	@JsonIgnore
	private ViolationDTO violationDTOs;

}
