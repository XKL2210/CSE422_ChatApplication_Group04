package ktn.chat.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServicesTest {
	UserServices userServices;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("UserServicesTest Online");
		System.out.println("UserServicesTest Inititated...");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("...UserServicesTest Offline");
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
