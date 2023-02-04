package KTN.chat.models;

public class Member {
	private User userProfile;
	private String role;
	
	public Member(User userProfile) {
		this.userProfile = userProfile;
		this.role = "Member";
	}
	
	public User getUserProfile() {
		return userProfile;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setUserProfile(User user) {
		this.userProfile = user;
	}
	
	public void setRoleToAdmin() {
		this.role = "Admin";
	}
	
	public void setRoleToMember() {
		this.role = "Member";
	}
}
