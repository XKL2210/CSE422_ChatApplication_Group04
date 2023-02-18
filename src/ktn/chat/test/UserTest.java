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

class UserTest {
	User user;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("User Testing Inititated...");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("...User Testing Offline");
	}

	@BeforeEach
	void setUp() throws Exception {
		user = new User("User01", "1234", "Sahn", "Uzal", LocalDate.of(2000, 10, 22), Gender.Male);
	}

	@Test
	@DisplayName("Test 01: Password Check")
	void test01() {
		assertEquals(true, user.checkPassword("1234"));
		System.out.println("...Test 01: Executed...");
	}
}
