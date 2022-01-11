package com.accenture.lkm.junit_demo;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS) //Determines lifecycle of test instance for annotated testcase.
class MyCalculatorTest1 {

	private MyCalculator theCalculator;

	@BeforeAll
	void setupCalc() {
		System.out.println("Setting up Calculator");
		theCalculator = new MyCalculator();
	}

	@AfterAll
	void tearDwonCalc() {
		System.out.println("Tearing Down Calculator");
		theCalculator = null;
		System.gc();
	}
	@Test
	@DisplayName("Addition Test")
	public void testGetSum() {

		int a = 5;
		int b = 10;
		// Checks the sum of two (2) positive values
		Assertions.assertEquals(15, (theCalculator.getSum(a, b)));
		Assertions.assertEquals(15, (theCalculator.getSum(b, a)));

		a = -5;
		b = 10;
		// Checks the sum of a postive value and a negative value
		Assertions.assertEquals(5, (theCalculator.getSum(a, b)));
		Assertions.assertEquals(5, (theCalculator.getSum(b, a)));

		a = -5;
		b = -10;
		// Checks the sum of two (2) negative values
		Assertions.assertEquals(-15, (theCalculator.getSum(a, b)));
		Assertions.assertEquals(-15, (theCalculator.getSum(b, a)));
	}

}

