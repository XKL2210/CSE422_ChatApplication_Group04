package ktn.chat.models;

import java.util.ArrayList;

public class PublicGroup extends Group {
	private String accessPasscode;

	protected PublicGroup(String id, String name, User founder, String accessPasscode) {
		super(id, name, founder);
		this.accessPasscode = accessPasscode;
	}
	
	public String getAccessPasscode() {
        return accessPasscode;
    }

    public void setAccessPasscode(String accessPasscode) {
        this.accessPasscode = accessPasscode;
    }
}
