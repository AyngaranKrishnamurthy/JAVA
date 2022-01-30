package com.solution.test.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class JPAUtility
{
	private static EntityManagerFactory entityManagerFactory;
	
public static EntityManagerFactory getFactory()
{
	try
	{
	entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return entityManagerFactory;
}
public static void destroyFactory()
{
	if(entityManagerFactory!=null && entityManagerFactory.isOpen())
	{
		entityManagerFactory.close();
	}
}
}
