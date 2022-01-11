package com.accenture.lkm.junit_demo;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class TestFactoryTest {
	
	 ArrayList<Integer> intlist = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8));
	
	@TestFactory
	  public Stream<DynamicTest> testOneThroughTen() {
		
		
		return intlist.stream().map(i-> DynamicTest.dynamicTest("TestName",  () -> Assertions.assertTrue(i != 6,"equal to 6")));
		//Her the condition is i is anything but 6 hence when 6 is checked it return test  case failed
	   }

}
