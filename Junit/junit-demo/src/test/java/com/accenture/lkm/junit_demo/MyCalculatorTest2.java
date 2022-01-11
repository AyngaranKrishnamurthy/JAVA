package com.accenture.lkm.junit_demo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class MyCalculatorTest2 {

	private MyCalculator theCalculator1  = new MyCalculator();

	@BeforeEach
	void startTest(TestInfo testInfo) {
		System.out.println("Start Executing Test..." + testInfo.getDisplayName());
	}

	@AfterEach
	void endTest(TestInfo testInfo) {
		System.out.println("Completed Test..." + testInfo.getDisplayName());
	}

	@Test
	public void testGetSum() {

		int a = 5;
		int b = 10;
		// Checks the sum of two (2) positive values
		assertEquals(15, (theCalculator1.getSum(a, b)));
		assertEquals(15, (theCalculator1.getSum(b, a)));

		a = -5;
		b = 10;
		// Checks the sum of a postive value and a negative value
		assertEquals(5, (theCalculator1.getSum(a, b)));
		assertEquals(5, (theCalculator1.getSum(b, a)));

		a = -5;
		b = -10;
		// Checks the sum of two (2) negative values
		assertEquals(-15, (theCalculator1.getSum(a, b)));
		assertEquals(-15, (theCalculator1.getSum(b, a)));
	}


}
