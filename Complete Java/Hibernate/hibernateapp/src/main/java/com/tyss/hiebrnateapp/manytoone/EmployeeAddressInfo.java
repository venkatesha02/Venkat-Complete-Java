package com.tyss.hiebrnateapp.manytoone;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.tyss.hibernateapp.dto.EmployeePrimaryInfo;

import lombok.Data;
import lombok.ToString.Exclude;
@Data
@Entity
@Table(name="Employee_AddressInfo")
public class EmployeeAddressInfo implements Serializable {
	@EmbeddedId
	private EmployeeAddressPK addressPK;
	@Column
	private String houseNo;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String landMark;
	@Column
	private String city;
	@Column
	private long pinCode;
	@Exclude
	@MapsId("empId")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	private EmployeePrimaryInfo primary;
	


}
