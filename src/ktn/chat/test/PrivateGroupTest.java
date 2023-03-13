package ktn.chat.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ktn.chat.enums.Gender;
import ktn.chat.models.PrivateGroup;
import ktn.chat.models.User;

public class PrivateGroupTest {
	User user;
	User admin;
	PrivateGroup group;
	List<User> members;

	@BeforeEach
	void setUp() throws Exception {
		user = new User("User01", "1234", "Sahn", "Uzal", LocalDate.of(2000, 10, 22), Gender.MALE);
		admin = new User("Admin01", "1234", "Sahn", "Uzal", LocalDate.of(2000, 10, 22), Gender.MALE);
		group = new PrivateGroup("Group01", "Nhan", admin, members);

	}

	@Test
	@DisplayName("Test 01: getAdmin")
	void test01() {
		assertEquals(admin, group.getAdmin());
		System.out.println("Test 01: Executed");
	}

	@Test
	@DisplayName("Test 02: setAdmin")
	void test02() {
		group.setAdmin(user);
		System.out.println("Test 02: Executed");
	}

	@Test
	@DisplayName("Test 03: isAdmin")
	void test03() {
		assertEquals(true, group.isAdmin(admin));
		System.out.println("Test 03: Executed");
	}

	@Test
	@DisplayName("Test 04: removeAdmin")
	void test04() {
		group.removeMember(admin, user);
		System.out.println("Test 04: Executed");
	}

}