package com.dbs.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// What to test - methods in classes from service and controller packages 
// unit testing - testing methods 
// mockito 

@SpringBootTest
class AppTests {

	// positive test case
	@Test
	public void testSomeMethod() {
		int expected = 10, actual = 10;
		assertEquals(expected, actual);
	}

	// negative test case
	@Test
	public void testSomeMethodNegative() {
		int unexpected = 11, actual = 10;
		assertNotEquals(unexpected, actual);
	}

	// @Test
//	void contextLoads() {
//	}

}
