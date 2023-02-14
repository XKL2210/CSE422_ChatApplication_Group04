package ktn.chat.models;

import java.util.ArrayList;

import ktn.chat.enums.Role;

public class PrivateGroup extends Group {
	private User admin;
    private String accessPasscode;
    
	public PrivateGroup(String id, String name, User founder, String accessPasscode) {
        super(id, name, founder);
        this.admin = founder;
        this.accessPasscode = accessPasscode;

        // Set founder as admin
        setAdminRole(founder);
    }

	public User getAdmin() {
        return admin;
    }

    public String getAccessPasscode() {
        return accessPasscode;
    }

    public void setAccessPasscode(String accessPasscode) {
        this.accessPasscode = accessPasscode;
    }
    
    public void setAdmin(User admin) {
        this.admin = admin;
        setAdminRole(admin);
    }

    public boolean isAdmin(User user) {
        return getRole(user) == Role.Admin;
    }
}
