package com.solution.test.service;

import java.sql.SQLException;

import com.solution.test.businessbean.EmployeeBean;

public interface EmployeeService {
	public int insertEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException,Exception;
	public void readEmployee() throws ClassNotFoundException, SQLException;
	public void updateEmployee(EmployeeBean bean) throws SQLException, ClassNotFoundException;
	public void deleteEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException;
	

}
