package com.rule.violation.details.exceptionformat;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionFormat {

	private String msg;
	private Date timeStamp;
	private String details;

}
