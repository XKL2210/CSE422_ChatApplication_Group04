package ktn.chat.services;

import java.time.LocalDate;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.Gender;
import ktn.chat.models.Alias;
import ktn.chat.models.User;

public class UserServices {
	DataStorage dataStorage;
	User currentUser;

	public UserServices() {
		dataStorage = new DataStorage();
	}

	public User getUser(String username) {
		return dataStorage.getUserRepository().find(u -> u.getUsername().equals(username));
	}

	public boolean SignUp(String userName, String password, String firstName, String lastName, LocalDate dateOfBirth,
			Gender gender) {
		User registerUser = getUser(userName);
		if (registerUser == null) {
			User newUser = new User(userName, password, firstName, lastName, dateOfBirth, gender);
			dataStorage.getUserRepository().insert(newUser);
			return true;
		} else {
			System.out.println("Username is already exists");
			return false;
		}
	}

	public boolean SignIn(String username, String pwd) {
		currentUser = getUser(username);

		if (currentUser != null && currentUser.checkPassword(pwd)) {
			System.out.println("Signed in successfully");
			return true;
		} else {
			System.out.println("The Username or Password is incorrect");
			return false;
		}
	}
	
	public boolean setAlias(String currentUsername, String targetUsername, String aliasName) {
		currentUser = getUser(currentUsername);
		User targetUser = getUser(targetUsername);
		
		if(currentUsername != null && targetUser != null) {
			Alias alias = new Alias(currentUser, targetUser, aliasName);
			currentUser.getAliasList().put(targetUser, alias);
			return true;
		} else {
			return false;
		}
	}
	
	public Alias getAlias(String currentUsername, String targetUsername) {
		currentUser = getUser(currentUsername);
		User targetUser = getUser(targetUsername);
		
		if(currentUsername != null && targetUser != null) {
			currentUser.getAliasList().get(targetUser);
			return currentUser.getAliasList().get(targetUser);
		}
		
		return null;
	}

	public boolean removeUser(String username) {
		if (currentUser != null) {
			dataStorage.getUserRepository().delete(currentUser);
			return true;
		}
		return false;
	}
}
