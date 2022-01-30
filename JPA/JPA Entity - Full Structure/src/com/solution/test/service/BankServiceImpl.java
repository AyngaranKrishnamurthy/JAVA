package com.solution.test.service;

import com.solution.test.dao.BankDAO;
import com.solution.test.dao.BankDAOImpl;
import com.solution.test.bean.BankBean;
import com.solution.test.utility.Validation;


public class BankServiceImpl implements BankService {
	private BankDAO dao;

	@Override
	public String createBank(BankBean bank) 
	{
		Validation v=new Validation();
		boolean b=false;
		b=v.checkDataType(bank.getBankName());
		if(b!=false)
		{
		dao=new BankDAOImpl();
		dao.createBank(bank);
		return "Bank Saved seuccessfully";
		}
		
		return "Validation failed, Retry...";
	}

}
