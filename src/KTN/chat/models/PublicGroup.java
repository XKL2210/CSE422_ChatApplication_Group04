package KTN.chat.models;

import java.util.ArrayList;

public class PublicGroup extends Group {

	public PublicGroup(String id, User founder, ArrayList<User> users) {
		super(id, founder, users);
		
	}
}
