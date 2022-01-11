package com.accenture.lkm.junit_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(Lifecycle.PER_CLASS)
class MyCalculatorTest {

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
		System.gc(); //garbage collector
	}

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

	@Test
	public void testGetDifference() {

		int a = 3;
		int b = 2;
		// Checks if b is lesser than a
		assertEquals(1, (theCalculator.getDifference(a, b)));
		// Checks if b is greater than a
		assertEquals(-1, (theCalculator.getDifference(b, a)));

		a = 5;
		b = -4;
		// Checks if negative value is subtracted from positive value
		assertEquals(9, (theCalculator.getDifference(a, b)));
		// Checks if positive value is subtracted from negative value
		assertEquals(-9, (theCalculator.getDifference(b, a)));

		a = -10;
		b = -5;
		// Checks if negative value is subtracted from negative value: a > b
		assertEquals(-5, (theCalculator.getDifference(a, b)));
		// Checks if negative value is subtracted from negative value: b < a
		assertEquals(5, (theCalculator.getDifference(b, a)));
	}

	@Test
	@DisplayName("Multiplication Test")
	public void testGetProduct() {

		double a = 5;
		double b = 10;
		// Checks the product of two (2) positive values
		assertEquals(50, (theCalculator.getProduct(a, b)));
		assertEquals(50, (theCalculator.getProduct(b, a)));

		a = -5;
		b = 10;
		// Checks the product of a postive value and a negative value
		assertEquals(-50, (theCalculator.getProduct(a, b)));
		assertEquals(-50, (theCalculator.getProduct(b, a)));

		a = -3;
		b = -10;
		// Checks the product of two (2) negative values
		assertEquals(30, (theCalculator.getProduct(a, b)));
		assertEquals(30, (theCalculator.getProduct(b, a)));
	}

	@Test
	public void testGetQuotient() {

		double a = 10;
		double b = 5;
		// Checks if b is lesser than a
		assertEquals(2, (theCalculator.getQuotient(a, b)));
		// Checks if b is greater than a
		assertEquals(0.5, (theCalculator.getQuotient(b, a)));

		a = 9;
		b = -3;
		// Checks if positive value is divided with negative value
		assertEquals(-3, (theCalculator.getQuotient(a, b)));
		// Checks if negative value is divided with positive value
		assertEquals(-0.33, (theCalculator.getQuotient(b, a)), 1);

		a = -10;
		b = -5;
		// Checks if negative value is divided with negative value: a > b
		assertEquals(2, (theCalculator.getQuotient(a, b)));
		// Checks if negative value is divided with negative value: b < a
		assertEquals(0.5, (theCalculator.getQuotient(b, a)));
	}

	@Test
	public void testThrowException() {

		try {

			theCalculator.getSum(2, 1);
			theCalculator.getDifference(3, 3);
			theCalculator.getProduct(0, 1);
			theCalculator.getQuotient(1, 0);
			new MyCalculator();

		} catch (Exception e) {
			fail("");
		} catch (Error e) {
			fail("");
		}
	}

	@RepeatedTest(3)
	void repeatedMultiplicationTest() {
		System.out.println("---Inside repeated Product Testing---");

		assertEquals(30, theCalculator.getProduct(5, 6), "6 * 5 will be 30");
	}

	@ParameterizedTest
	@ValueSource(strings = { "Accenture", "Java","" })//remove null for positive
	void checkStringLength(String stringinput) {
		System.out.println("---Inside Check length of String---");
		assertTrue(theCalculator.getStringLength(stringinput)>1, "stinginput length is less");
		
	}
}

