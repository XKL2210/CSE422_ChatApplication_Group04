package ktn.chat.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ktn.chat.enums.Gender;

class UserServicesTest {
	UserServices userServices = new UserServices();

	@BeforeAll
	static void testOnline() throws Exception {
		System.out.println("UserServicesTest Online");
		System.out.println("UserServicesTest Inititated...");
	}

	@AfterAll
	static void testOffline() throws Exception {
		System.out.println("...UserServicesTest Offline");
	}
	
	@BeforeEach
	void objectInitialization() throws Exception {
		userServices = new UserServices();
	}

	@Test
	@DisplayName("Test 01: User creation")
	void test01() {
		boolean successToken = userServices.SignUp("SahnUzal2210", "ak071292", "Sahn", "Uzal", LocalDate.of(2020, 10, 22), Gender.Male);
		assertEquals(successToken, true);
	}
	
	@Test
	@DisplayName("Test 02: User sign in")
	void test02() {
		userServices.SignUp("SahnUzal2210", "ak071292", "Sahn", "Uzal", LocalDate.of(2020, 10, 22), Gender.Male);
		boolean successToken = userServices.SignIn("SahnUzal2210", "ak071292");
		assertEquals(successToken, true);
	}
	
	@Test
	@DisplayName("Test 03: User remove")
	void test03() {
		userServices.SignUp("SahnUzal2210", "ak071292", "Sahn", "Uzal", LocalDate.of(2020, 10, 22), Gender.Male);
		userServices.SignIn("SahnUzal2210", "ak071292");
		boolean successToken = userServices.removeUser("SahnUzal2210");
		assertEquals(successToken, true);
	}
}
