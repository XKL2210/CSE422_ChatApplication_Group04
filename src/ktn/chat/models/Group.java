package ktn.chat.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ktn.chat.enums.Role;

public abstract class Group {
	private String id;
	private String name;
	private User founder;
	private List<User> members;
	private Map<String, Role> roles;
	private int adminCount;
	private int memberCount;

	protected Group(String id, String name, User founder, List<User> members) {
		this.id = id;
		this.name = name;
		this.founder = founder;
		this.members = members;
		roles = new HashMap<>();
		roles.put(founder.getUserName(), Role.MEMBER);
		adminCount++;
	}

	// Functional Methods
	public void addMember(User user, Role role) {
		members.add(user);
		increaseCount(role);
		roles.put(user.getUserName(), role);
	}

	public void increaseCount(Role role) {
		if (role == Role.ADMIN) {
			adminCount++;
		} else {
			memberCount++;
		}
	}

	public void decreaseCount(Role role) {
		if (role == Role.ADMIN) {
			adminCount--;
		} else {
			memberCount--;
		}
	}

	public Role getRole(User user) {
		return roles.get(user.getUserName());
	}

	public boolean isMember(User user) {
		return members.contains(user);
	}

	public void removeRole(User user) {
		decreaseCount(roles.get(user.getUserName()));
		roles.remove(user.getUserName());
	}

	public void removeUser(User user) {
		members.removeIf(n -> n.getUserName().equals(user.getUserName()));
	}

	// Getter
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public User getFounder() {
		return founder;
	}

	public int getAdminCount() {
		return adminCount;
	}

	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setMemberRole(User user) {
		roles.put(user.getUserName(), Role.MEMBER);
		decreaseCount(roles.get(user.getUserName()));
		increaseCount(Role.MEMBER);
	}

	public void setAdminRole(User user) {
		roles.put(user.getUserName(), Role.ADMIN);
		decreaseCount(roles.get(user.getUserName()));
		increaseCount(Role.ADMIN);
	}
}