package ktn.chat.models;

import java.util.List;

public class PublicGroup extends Group {
	private String accessPasscode;

	public PublicGroup(String id, String name, User founder, List<User> members, String accessPasscode) {
		super(id, name, founder, members);
		this.accessPasscode = accessPasscode;
	}

	// Getter
	public String getAccessPasscode() {
		return accessPasscode;
	}

	// Setter
	public void setAccessPasscode(String accessPasscode) {
		this.accessPasscode = accessPasscode;
	}
}
