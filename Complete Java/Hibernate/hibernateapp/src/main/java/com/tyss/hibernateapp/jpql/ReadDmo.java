package com.tyss.hibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.tyss.hibernateapp.dto.Movie;

public class ReadDmo {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

		EntityManager manager = factory.createEntityManager();
		String jpql = "select m from Movie m where m.id=:mid ";
   //  Query query=manager.createQuery(jpql);
		TypedQuery<Movie> query = manager.createQuery(jpql,Movie.class);
		query.setParameter("mid",110);
		Movie movie = query.getSingleResult();
			System.out.println("Movie Id-----" + movie.getId());
			System.out.println("Movie Name---" + movie.getName());
			System.out.println("Movie Rating---" + movie.getRating());
			System.out.println("================");
		
	}//

}//
