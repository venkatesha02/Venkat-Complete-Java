package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Movie;

public class UpdateDemo {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Movie record=manager.find(Movie.class,102);
			record.setName("qwertyui");
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
