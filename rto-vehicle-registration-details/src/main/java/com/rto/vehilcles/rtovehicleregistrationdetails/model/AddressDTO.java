/*package com.rto.vehilcles.rtovehicleregistrationdetails.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddressDTO {
	@Id
	@Column
	private String addrId;
	@Column
	private String addrLine;
	@Column
	private String city;
	@Column
	private String state;

	@OneToOne(mappedBy="address")
	private OwnerDTO ownerDTO; 
}
*/