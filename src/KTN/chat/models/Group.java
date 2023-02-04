package KTN.chat.models;

import java.util.ArrayList;

public abstract class Group {
	private String id;
	private String name;
	private User founder;
	private ArrayList<Member> members;

	public Group(String id, User founder, ArrayList<User> users) {
		members = new ArrayList<>();
		this.id = id;
		this.founder = founder;
		Member founderMember = new Member(founder);
		
		users.forEach(user -> {
            Member member = new Member(user);
            this.members.add(member);
        });
		
		members.add(founderMember);
		members = new ArrayList<>();
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

	public User getFounder() {
		return founder;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}
}
