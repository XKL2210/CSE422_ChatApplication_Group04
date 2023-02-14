package ktn.chat.models;

import java.util.ArrayList;

import ktn.chat.enums.GroupMemberRole;

public class PrivateGroup extends Group{
	private String joinPasscode;

	public PrivateGroup(String id, User founder, ArrayList<User> users) {
		super(id, founder, users);
		
	}
	
	public String getJoinPasscode() {
        return joinPasscode;
    }

    public void setJoinPasscode(String joinPasscode) {
        this.joinPasscode = joinPasscode;
    }
}
