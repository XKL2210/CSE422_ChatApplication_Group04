package ktn.chat.services;

import ktn.chat.data.DataStorage;

public class UserServices {
	DataStorage dataStorage;
	
	public UserServices () {
		dataStorage = new DataStorage();
	}
}
