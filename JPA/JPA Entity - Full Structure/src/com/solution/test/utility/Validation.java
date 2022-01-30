package com.solution.test.utility;

public class Validation 
{
public static boolean checkDataType(Object object)
{
	boolean b=false;
	if(object.getClass().getName().endsWith("String"))
	{
		b=true;
		
	}
	return b;
}
}
