package com.solution.test.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.solution.test.entity.EmployeeEntity;

public class DeleteOperation {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, 1005); //Finding the employee
		if(employeeEntity != null) {
		entityManager.getTransaction().begin();
		entityManager.remove(employeeEntity);	//Removing the retrieved employee
		entityManager.getTransaction().commit();
		System.out.println("Employee deleted successfully!!");
		} else {
			System.out.println("Please give a valid ID!!");	
		}
		entityManager.close();
		entityManagerFactory.close();
	}
}
