package com.violation.mail.mailingservice.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {
	private String ownerId;
	private String ownerName;
	private String ownerPAN;
	private String ownerAddar;
	private String ownerDL;
	private Date dob;
	private String nationality;
	private String address;
	private List<VehicleDTO> vehicleDTOs;
}