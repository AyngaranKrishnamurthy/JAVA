package com.solution.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.solution.test.bean.BankBean;
import com.solution.test.config.JPAUtility;
import com.solution.test.entity.*;

public class BankDAOImpl implements BankDAO {

	@Override
	public void createBank(BankBean bank)
	{
		EntityManagerFactory factory=JPAUtility.getFactory();
		EntityManager manager=factory.createEntityManager();
		manager.getTransaction().begin();
	    Bank bnk=new Bank();
	    bnk.setBankName(bank.getBankName());
	    Address a1=new Address();
	    Address a2=new Address();
	    a1.setCity(bank.getAddressBean().get(0).getCity());
	    a1.setState(bank.getAddressBean().get(0).getState());
	    
	    a2.setCity(bank.getAddressBean().get(1).getCity());
	    a2.setState(bank.getAddressBean().get(1).getState());
	    
	    
	    bnk.getAddress().add(a1);
	    bnk.getAddress().add(a2);
	    //manager.persist(adrs);
	    manager.persist(bnk);
	    manager.getTransaction().commit();
	    manager.close();
		
	}

}
