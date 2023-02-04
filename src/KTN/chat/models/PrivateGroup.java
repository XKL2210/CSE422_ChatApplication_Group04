package KTN.chat.models;

import java.util.ArrayList;

public class PrivateGroup extends Group{

	public PrivateGroup(String id, User founder, ArrayList<User> users) {
		super(id, founder, users);
		
	}
}
