package com.tyss.hibernateapp.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EmpPrimary movie = new EmpPrimary();
		movie.setId(65);
		movie.setName("dfgdf");
		movie.setRating("good");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("yantra");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(movie);
		System.out.println("inserted");
		transaction.commit();
		
	}

}
