package com.solution.test.ui;

import com.solution.test.service.BankServiceImpl;
import com.solution.test.service.BankService;
import com.solution.test.bean.AddressBean;
import com.solution.test.bean.BankBean;
import com.solution.test.config.JPAUtility;

public class UITester {
	 private static BankService service;
		public static void main(String[] args)
		{
			createBank();
			JPAUtility.destroyFactory();

		}
		
		public static void createBank()
		{
			service=new BankServiceImpl();
			BankBean bean=new BankBean();
			bean.setBankName("HDFC");
			
		     AddressBean adBean1=new AddressBean();
		     adBean1.setCity("Lucknow");
		     adBean1.setState("UP");
		     
		     AddressBean adBean2=new AddressBean();
		     adBean2.setCity("Kanpur");
		     adBean2.setState("UP");
		    
		     bean.getAddressBean().add(adBean1);
		     bean.getAddressBean().add(adBean2);
			System.out.println(" "+service.createBank(bean));

		}
		public static void  remove()
		{
			service=new BankServiceImpl();
			

		}

	}
