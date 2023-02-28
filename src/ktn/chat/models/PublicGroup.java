package ktn.chat.models;

import java.util.List;

public class PublicGroup extends Group {
	String accessPasscode;

	public PublicGroup(String id, String name, User founder, List<User> members, String accessPasscode) {
		super(id, name, founder, members);
		this.accessPasscode = accessPasscode;
	}
	//Getter
	public String getPasscode() {
		return accessPasscode;
	}
	//Setter
	public void setPasscode(String accessPasscode) {
		this.accessPasscode = accessPasscode;
	}
}
