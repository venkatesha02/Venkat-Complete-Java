package com.tyss.hibernateapp.onetone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tyss.hibernateapp.dto.EmployeePrimaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="EmployeeSecondaryInfo")
public class EmployeeSecondaryInfo implements Serializable {
	@Id
	private int empId;
	@Column
	private String gender;
	@Column
	private String personalEmail;
	@Column
	private String jobLocation;
	@Column
	private String isMarried;
	@Column
	private String nationality;
	@Column
	private String guradianName;
	@Column
	private long guradianNumber;
	@Column
	private String govtId;
	@Exclude
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private EmployeePrimaryInfo primary;
}
