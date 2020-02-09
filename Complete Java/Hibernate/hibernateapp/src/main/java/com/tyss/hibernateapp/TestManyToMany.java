package com.tyss.hibernateapp;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.EmployeePrimaryInfo;
import com.tyss.hibernateapp.manytomany.ProjectInfo;

public class TestManyToMany {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		EmployeePrimaryInfo primaryInfo = new EmployeePrimaryInfo();
		ProjectInfo project=new ProjectInfo();
		ProjectInfo project1=new ProjectInfo();
		ArrayList<ProjectInfo> arrayLis = new ArrayList<ProjectInfo>();
		
		
		
		primaryInfo.setEmpId(105);
		primaryInfo.setName("Jacks");
		primaryInfo.setDateOfBirth(java.sql.Date.valueOf("1993-12-10"));
		primaryInfo.setDepartmentId(30);
		primaryInfo.setDesgination("hr");
		primaryInfo.setJoinningDate(java.sql.Date.valueOf("2018-09-22"));
		primaryInfo.setManagerId(4);
		primaryInfo.setMobileNo(8377841525L);
		primaryInfo.setOfficalMailId("rahul@tyss.com");
		primaryInfo.setSalary(440333.00);
		primaryInfo.setProjectInfo(arrayLis);

		EmployeePrimaryInfo primaryInfo1 = new EmployeePrimaryInfo();

		primaryInfo1.setEmpId(104);
		primaryInfo1.setName("Ravi");
		primaryInfo1.setDateOfBirth(java.sql.Date.valueOf("1990-02-13"));
		primaryInfo1.setDepartmentId(20);
		primaryInfo1.setDesgination("tester");
		primaryInfo1.setJoinningDate(java.sql.Date.valueOf("2017-09-22"));
		primaryInfo1.setManagerId(4);
		primaryInfo1.setMobileNo(8377841525L);
		primaryInfo1.setOfficalMailId("ravi@tyss.com");
		primaryInfo1.setSalary(550333.00);
		ArrayList<EmployeePrimaryInfo> arrayList = new ArrayList<EmployeePrimaryInfo>();
		arrayList.add(primaryInfo);
		arrayList.add(primaryInfo1);
		
		project.setPid(23);
		project.setProjectName("Ecom");
		project.setStartDate(java.sql.Date.valueOf("2010-02-13"));
		project.setEndDate(java.sql.Date.valueOf("2020-02-13"));
		project.setTechnology("java");
		project.setLocation("USA");
		project.setPrimaryInfo(arrayList);
		
		project1.setPid(24);
		project1.setProjectName("JSP");
		project1.setStartDate(java.sql.Date.valueOf("2010-02-13"));
		project1.setEndDate(java.sql.Date.valueOf("2020-02-13"));
		project1.setTechnology("java");
		project1.setLocation("USA");
		
		arrayLis.add(project);
		arrayLis.add(project1);

		try {
			factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(primaryInfo);
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		} finally {
			manager.close();
			factory.close();
		}

	}// End Of the Method

}// End Of the Class
