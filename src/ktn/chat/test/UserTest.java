package ktn.chat.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ktn.chat.enums.Gender;
import ktn.chat.models.User;
//Testing JUnit the purpose of this class is to practice on JUnit for all collaborators 
class UserTest {
	User user;
	
	@BeforeAll
	static void testOnline() throws Exception {
		System.out.println("UserServicesTest Online");
		System.out.println("UserTest Inititated...");
	}

	@AfterAll
	static void testOffline() throws Exception {
		System.out.println("...UserTest Offline");
	}

	@BeforeEach
	void objectInitialization() throws Exception {
		user = new User("User01", "1234", "Sahn", "Uzal", LocalDate.of(2000, 10, 22), Gender.Male);
	}

	@Test
	@DisplayName("Test 01: Password Check")
	void test01() {
		assertEquals(true, user.checkPassword("1234"));
		System.out.println("Test 01: Executed");
	}
	@Test
	@DisplayName("Test 02: FirstNameCheck")
	void test02() {
		assertEquals("Sahn", user.getFirstName());
		System.out.println("Test 02: Executed");
	}
}
