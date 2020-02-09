package com.tyss.hibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
			String jpql = "update Movie m set m.name=:nm where m.id=:mid";
			Query query = manager.createQuery(jpql);
			query.setParameter("mid",110);
			query.setParameter("nm","The Mummy Return");
			
			int result = query.executeUpdate();
			System.out.println("No of the Count------" + result);
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
