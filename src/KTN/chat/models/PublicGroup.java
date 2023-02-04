package KTN.chat.models;

import java.util.ArrayList;

public class PublicGroup extends Group {
	
	private String accessPasscode;

	public PublicGroup(String id, User founder, ArrayList<User> users, String accessPasscode) {
		super(id, founder, users);
		this.accessPasscode = accessPasscode;
    }

    public String getAccessCode() {
        return accessPasscode;
    }

    public void setAccessCode(String accessCode) {
        this.accessPasscode = accessPasscode;
    }
}
