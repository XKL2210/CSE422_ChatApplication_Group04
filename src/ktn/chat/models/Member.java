package ktn.chat.models;

import ktn.chat.enums.GroupMemberRole;

public class Member {
	private User userProfile;
	private GroupMemberRole role;
	
	public Member(User userProfile, GroupMemberRole role) {
		this.userProfile = userProfile;
		this.role = role;
	}
	
	public User getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(User user) {
		this.userProfile = user;
	}
	
	public void setRoleToAdmin() {
		this.role = GroupMemberRole.Admin;
	}
	
	public void setRoleToMember() {
		this.role = GroupMemberRole.Member;
	}
}
