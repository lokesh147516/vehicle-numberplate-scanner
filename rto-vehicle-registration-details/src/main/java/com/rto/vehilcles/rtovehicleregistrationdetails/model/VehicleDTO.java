package com.rto.vehilcles.rtovehicleregistrationdetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Vehicle_Details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

	@Id
	@Column
	private String numberPlate;
	@Column
	private String vehicleName;
	@Column
	private String vehicleManufacturer;
	@Column
	private String vehicleOrgnlColor;
	@Column
	private int manufactureYear;
	@Column
	private int soldYear;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ownerId", nullable=false)
	private OwnerDTO owner;
	@Column
	private String rcNumber;
	@Column
	private String chassisNum;
	@Column
	private String engineNumber;
	@Column
	private String fuelType;
	
	
	
	

	}
