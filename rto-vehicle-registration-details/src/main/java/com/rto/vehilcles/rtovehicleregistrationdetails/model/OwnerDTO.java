package com.rto.vehilcles.rtovehicleregistrationdetails.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Owner_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {

	@Id
	@Column
	private String ownerId;
	@Column
	private String ownerName;
	@Column
	private String ownerPAN;
	@Column
	private String ownerAddar;
	@Column
	private String ownerDL;
	@Column
	private Date dob;
	@Column
	private String nationality;
	@Column
	private String address;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="owner")
	private List<VehicleDTO> vehicleDTOs;
	
	
}


