package ktn.chat.test;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;

import ktn.chat.enums.Gender;
import ktn.chat.models.PublicGroup;
import ktn.chat.models.User;

public class PublicGroupTest {
	User user;
	PublicGroup group;

	@BeforeEach
	void setUp() throws Exception {
		user = new User("User01", "1234", "Sahn", "Uzal", LocalDate.of(2000, 10, 22), Gender.MALE);
		group = new PublicGroup("Group01", "Nhan", user, null, "nnn");
	}
}
