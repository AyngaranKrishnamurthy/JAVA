package com.solution.test.ui;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.solution.test.entity.EmployeeEntity;

public class CreateOperation {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1"); //EntityManagerFactory created using the name in persistence.xml
		EntityManager entityManager = entityManagerFactory.createEntityManager();	//Instance of EntityManager created using EntityManagerFactory
		EmployeeEntity employee = new EmployeeEntity(); //Object of EmployeeEntity class
		employee.setEmployeeId(1005);
		employee.setEmployeeName("ABCD");
		employee.setRole("Analyst");
		employee.setSalary(200000.0);
		employee.setInsertTime(new Date());
		
		entityManager.getTransaction().begin();		//Transaction begins
		entityManager.persist(employee);			//Transactions are being processed
		entityManager.getTransaction().commit();	//Transaction commits/saves
		System.out.println("Employee registered successfully!!");
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
