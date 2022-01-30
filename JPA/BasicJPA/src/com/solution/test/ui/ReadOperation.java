package com.solution.test.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.solution.test.entity.EmployeeEntity;

public class ReadOperation {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EmployeeEntity employeeEntity =  entityManager.find(EmployeeEntity.class, 1005); //Object of entitymanager used to find employee.
		System.out.println("Employee Id: "+employeeEntity.getEmployeeId()+"\n"+
				"Employee Name: "+employeeEntity.getEmployeeName()+"\n"+
				"Employee Role: "+employeeEntity.getRole()+"\n"+
				"Employee insert date: "+employeeEntity.getInsertTime()+"\n"+
				"Employee Salary: "+employeeEntity.getSalary()); 
		entityManager.close();
		entityManagerFactory.close();

		
	}
}
