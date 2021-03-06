package com.solution.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: EmployeeEntity
 *
 */
@Entity
@Table(name = "Employee")
public class EmployeeEntity {
	public EmployeeEntity() {
		super();
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //uncomment the line if you want the id to be auto-generated
	private Integer employeeId;
	@Column(name = "emp_name")
	private String employeeName;
	private String role;
	
	@Temporal(TemporalType.DATE) //Used to assign current values like date,time,year, etc...
	private Date insertTime;
	private Double Salary;

	//setters and getters goes here

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

}
