package com.rule.violation.details.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "violation_fine_dtls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViolationDTO {
	@Id
	@Column
	private int ruleVioltedId;
	@Column
	private String violationName;
	@Column
	private String violationType;
	@Column
	private double fineAmt;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "violationDTOs")
	private List<ViolationVehicleDTO> violationVehicleDTO;

}
