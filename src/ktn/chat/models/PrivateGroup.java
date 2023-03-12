package ktn.chat.models;

import java.util.ArrayList;
import java.util.List;

import ktn.chat.enums.Role;

public class PrivateGroup extends Group {
	private User admin;

	public PrivateGroup(String id, String name, User founder, List<User> members) {
		super(id, name, founder, members);
		this.admin = founder;

		// Set founder as admin
		setAdminRole(founder);
	}

	// Getter
	public User getAdmin() {
		return admin;
	}

	// Setter
	public void setAdmin(User user) {
		this.admin = user;
		setAdminRole(admin);
	}

	public boolean isAdmin(User user) {
		return getRole(user) == Role.ADMIN;
	}

	public void removeMember(User admin, User user) {
		if (isAdmin(user)) {
			removeRole(user);
			removeUser(user);
		}
	}
}
