package com.solution.test.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.solution.test.entity.EmployeeEntity;

public class UpdateOperation {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, 1005); //Finding the employee details
		if (employeeEntity != null) {	//checking if it exists
			entityManager.getTransaction().begin();
			employeeEntity.setSalary(150000.00);	//setting update value
			entityManager.getTransaction().commit();
			System.out.println("Employee updated successfully!!");
		} else {
			System.out.println("Employee is not found!!");
		}
		entityManager.close();
		entityManagerFactory.close();
	}
}
