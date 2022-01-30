package com.solution.test.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBproperties {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println("===Data source properties===");
		System.out.println("Driver name: "+entityManagerFactory.getProperties().get("javax.persistence.jdbc.driver"));
		System.out.println("JDBC URL: "+entityManagerFactory.getProperties().get("javax.persistence.jdbc.url"));
		System.out.println("Database username: "+entityManagerFactory.getProperties().get("javax.persistence.jdbc.user"));
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
