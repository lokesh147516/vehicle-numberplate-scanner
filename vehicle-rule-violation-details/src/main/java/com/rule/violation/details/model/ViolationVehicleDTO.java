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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rule_violation_vehicles_dtls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViolationVehicleDTO {

	@Id
	@Column
	private String violtdId;
	@Column
	private String violtedVehicleNumber;
	@Column
	private Date violatedDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ruleVioltedId", nullable=false)
	private ViolationDTO violationDTOs;

}
