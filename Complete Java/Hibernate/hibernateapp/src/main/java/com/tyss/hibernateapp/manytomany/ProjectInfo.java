package com.tyss.hibernateapp.manytomany;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.tyss.hibernateapp.dto.EmployeePrimaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="project_info")
public class ProjectInfo implements Serializable {
	@Id
	@Column
	private int pid;
	@Column
	private String projectName;
	@Column
	private String technology;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private String location;
	
	@Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="project_employee",joinColumns = @JoinColumn(name="pid"),
	inverseJoinColumns = @JoinColumn(name="empId"))
	private List<EmployeePrimaryInfo> primaryInfo;

}
