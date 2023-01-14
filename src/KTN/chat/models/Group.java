package KTN.chat.models;

import java.util.ArrayList;

public abstract class Group {
	private String id;
	private String name;
	private String founder;
	private ArrayList<Member> members;

	public Group(String id, String founder) {
		members = new ArrayList<>();
		this.id = id;
		this.founder = founder;
	}

	public void addMember(User user) {
		members.add(new Member(user));
	}

	public void removeMember(User user) {
		members.remove(new Member(user));
	}

	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFounder() {
		return founder;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}
}
