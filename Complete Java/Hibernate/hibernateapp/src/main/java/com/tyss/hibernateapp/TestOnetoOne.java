package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.EmployeePrimaryInfo;
import com.tyss.hibernateapp.onetone.EmployeeSecondaryInfo;

public class TestOnetoOne {

	public static void main(String[] args) {

		EntityTransaction transaction = null;
		EntityManager manager = null;
		EmployeePrimaryInfo primaryInfo = new EmployeePrimaryInfo();

		primaryInfo.setEmpId(101);
		primaryInfo.setName("Nikhil");
		primaryInfo.setDateOfBirth(java.sql.Date.valueOf("1997-12-10"));
		primaryInfo.setDepartmentId(30);
		primaryInfo.setDesgination("hr");
		primaryInfo.setJoinningDate(java.sql.Date.valueOf("2018-09-22"));
		primaryInfo.setManagerId(4);
		primaryInfo.setMobileNo(9909029209L);
		primaryInfo.setOfficalMailId("nikhil@tyss.com");
		primaryInfo.setSalary(440333.00);

		EmployeeSecondaryInfo secondaryInfo = new EmployeeSecondaryInfo();
		secondaryInfo.setGender("male");
		secondaryInfo.setGuradianName("Anil");
		secondaryInfo.setGuradianNumber(8957892565l);
		secondaryInfo.setJobLocation("chennai");
		secondaryInfo.setPersonalEmail("niki@gmail.com");
		secondaryInfo.setIsMarried("Single");
		secondaryInfo.setNationality("Indian");
		secondaryInfo.setGovtId("QWE546Hn");
		secondaryInfo.setPrimary(primaryInfo);
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			// manager.persist(secondaryInfo);
			EmployeePrimaryInfo primInfo = manager.find(EmployeePrimaryInfo.class, 101);
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
