package com.violation.mail.mailingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="officers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfficerDTO {

	@Id
	@Column
	private int officerId;
	@Column
	private String name;
	@Column
	private String mailId;
	@Column
	private String location;
	
}
