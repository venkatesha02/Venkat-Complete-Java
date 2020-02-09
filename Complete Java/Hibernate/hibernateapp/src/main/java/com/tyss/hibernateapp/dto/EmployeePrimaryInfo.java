package com.tyss.hibernateapp.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tyss.hibernateapp.manytomany.ProjectInfo;
import com.tyss.hibernateapp.onetone.EmployeeSecondaryInfo;
import com.tyss.hiebrnateapp.manytoone.EmployeeAddressInfo;

import lombok.Data;
@Data
@Entity
@Table(name="Employee_Primary_Info")
public class EmployeePrimaryInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int empId;
	@Column
	private String name;
	@Column
	private double salary;
	@Column
	private int departmentId;
	@Column
	private Date joinningDate;
	@Column
	private long mobileNo;
	@Column
	private String officalMailId;
	@Column
	private String desgination;
	@Column
	private Date dateOfBirth;
	@Column
	private int managerId;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy ="primary")
	private EmployeeSecondaryInfo secondaryInfo;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="primary")
	private List<EmployeeAddressInfo> addressInfo;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy ="primaryInfo")
	private List<ProjectInfo> projectInfo;

		 }
