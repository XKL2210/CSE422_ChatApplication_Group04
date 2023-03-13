package ktn.chat.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ktn.chat.enums.Gender;
import ktn.chat.models.PublicGroup;
import ktn.chat.models.User;

public class PublicGroupTest {
	User user;
	PublicGroup group;
	//String accessPasscode;
	@BeforeEach
	void setUp() throws Exception {
		user = new User("User01", "1234", "Sahn", "Uzal", LocalDate.of(2000, 10, 22), Gender.MALE);
		group = new PublicGroup("Group01", "Nhan", user, null, "nnn");

	}
	
	@Test
	@DisplayName("Test 01: getAccessPass")
	void test01() {
		assertEquals("nnn",group.getAccessPasscode());
		System.out.println("Test 01: Executed");
	}
	
	@Test
	@DisplayName("Test 02: setAccessPass")
	void test02() {
	group.setAccessPasscode("abc");
		System.out.println("Test 02: Executed");
	}
	
	
}
