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
	
	protected Group(String id, String name, User founder) {
		this.id = id;
		this.name = name;
		this.founder = founder;
		members = new ArrayList<>();
		roles = new HashMap<String, Role>();
		roles.put(founder.getUsername(), Role.Member);
	}
	//Functional Methods
	public void addMember(User user, Role role) {
        members.add(user);
        roles.put(user.getUsername(), role);
    }

    public Role getRole(User user) {
        return roles.get(user.getUsername());
    }

    public boolean isMember(User user) {
        return members.contains(user);
    }
	//Getter
	public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getFounder() {
        return founder;
    }
    //Setter
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMemberRole(User user) {
    	roles.put(user.getUsername(), Role.Member);
    }
    
    public void setAdminRole(User user) {
    	roles.put(user.getUsername(), Role.Admin);
    }
}