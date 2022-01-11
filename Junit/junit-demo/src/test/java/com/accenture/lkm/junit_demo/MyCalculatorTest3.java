package com.accenture.lkm.junit_demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyCalculatorTest3 {

	private MyCalculator theCalculator  = new MyCalculator();
	
	@RepeatedTest(3)
	void repeatedMultiplicationTest() {
		System.out.println("---Inside repeated Product Testing---");

		assertEquals(30, theCalculator.getProduct(5, 6), "6 * 5 will be 30");
	}

	@ParameterizedTest
	@ValueSource(strings = { "Accenture", "Java" })
	void checkStringLength(String stringinput) {
		System.out.println("---Inside Check length of String---");
		assertTrue(theCalculator.getStringLength(stringinput)>1, "stinginput length is less");
		
	}
	
	@Disabled
	@Test
	public void testGetSum() {

		int a = 5;
		int b = 10;
		// Checks the sum of two (2) positive values
		assertEquals(15, (theCalculator.getSum(a, b)));
		assertEquals(15, (theCalculator.getSum(b, a)));

		a = -5;
		b = 10;
		// Checks the sum of a postive value and a negative value
		assertEquals(5, (theCalculator.getSum(a, b)));
		assertEquals(5, (theCalculator.getSum(b, a)));

		a = -5;
		b = -10;
		// Checks the sum of two (2) negative values
		assertEquals(-15, (theCalculator.getSum(a, b)));
		assertEquals(-15, (theCalculator.getSum(b, a)));
	}
}
