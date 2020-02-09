package com.tyss.hibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.hibernateapp.dto.Movie;

public class InsertDemo {
	public static void main(String[] args) {

		Movie movie = new Movie();
		movie.setId(111);
		movie.setName("Kuch Kuch Hota Hai");
		movie.setRating("good");

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("test");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(movie);
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
