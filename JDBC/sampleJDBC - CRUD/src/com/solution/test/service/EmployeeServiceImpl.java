package com.solution.test.service;

import java.sql.SQLException;

import com.solution.test.businessbean.EmployeeBean;
import com.solution.test.dao.EmployeeDAO;
import com.solution.test.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public int insertEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException, Exception {
		 int rowsUpdateCount = 0;
		try {
			rowsUpdateCount	=  employeeDAO.insertEmployee(bean);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e){
			throw e;
		}
		return rowsUpdateCount;
		
	}

	@Override
	public void readEmployee() throws ClassNotFoundException, SQLException {
		try {
			employeeDAO.readEmployee();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			throw e;
		}

	}

	@Override
	public void updateEmployee(EmployeeBean bean) throws SQLException, ClassNotFoundException {
		try {
			employeeDAO.updateEmployee(bean);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteEmployee(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		try {
			employeeDAO.deleteEmployee(bean);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			throw e;
		}
	}

	

}