package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.EmployeePrimaryInfo;
import com.tyss.hibernateapp.onetone.EmployeeSecondaryInfo;
import com.tyss.hiebrnateapp.manytoone.EmployeeAddressInfo;
import com.tyss.hiebrnateapp.manytoone.EmployeeAddressPK;

public class TestManyToOne {

	public static void main(String[] args) {

		EntityTransaction transaction = null;
		EntityManager manager = null;

		EmployeePrimaryInfo primaryInfo = new EmployeePrimaryInfo();
		primaryInfo.setEmpId(102);
		primaryInfo.setName("Shanu");
		primaryInfo.setDateOfBirth(java.sql.Date.valueOf("1992-11-10"));
		primaryInfo.setDepartmentId(20);
		primaryInfo.setDesgination("hr");
		primaryInfo.setJoinningDate(java.sql.Date.valueOf("2018-09-22"));
		primaryInfo.setManagerId(4);
		primaryInfo.setMobileNo(9909029209L);
		primaryInfo.setOfficalMailId("nikhil@tyss.com");
		primaryInfo.setSalary(440333.00);
		
		
		EmployeeAddressPK addrespk = new EmployeeAddressPK();
		addrespk.setEmpId(102);
		addrespk.setAddressType("permant");

		EmployeeAddressInfo address = new EmployeeAddressInfo();
		address.setAddressPK(addrespk);
		address.setAddress1("jp nagar");
		address.setAddress2("7th phase");
		address.setHouseNo("one");
		address.setLandMark("tvs Showroom");
		address.setCity("ban");
		address.setPinCode(560078);
		address.setPrimary(primaryInfo);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			
			EmployeePrimaryInfo info=manager.find(EmployeePrimaryInfo.class,102);
			
			System.out.println(info.getAddressInfo().get(0).getAddressPK().getAddressType());
			
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}// End Of the Method
}// End Of the Class
