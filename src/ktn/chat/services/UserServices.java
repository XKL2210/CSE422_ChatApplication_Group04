package ktn.chat.services;

import java.time.LocalDate;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.Gender;
import ktn.chat.models.Alias;
import ktn.chat.models.User;

public class UserServices {
	private DataStorage dataStorage;
	private User currentUser;

	public UserServices() {
		dataStorage = new DataStorage();
	}

	public User getUser(String username) {
		return dataStorage.getUserRepository().find(u -> u.getUserName().equals(username));
	}

	public boolean signUp(String username, String password, String firstName, String lastName, LocalDate dateOfBirth,
			Gender gender) {
		User registerUser = getUser(username);
		if (registerUser == null) {
			User newUser = new User(username, password, firstName, lastName, dateOfBirth, gender);
			dataStorage.getUserRepository().insert(newUser);
			return true;
		} else {
			System.out.println("Username is already exists");
			return false;
		}
	}

	public boolean signIn(String username, String password) {
		currentUser = getUser(username);

		if (currentUser != null && currentUser.checkPassword(password)) {
			System.out.println("Signed in successfully");
			return true;
		} else {
			System.out.println("The username or password is incorrect");
			return false;
		}
	}

	public boolean setAlias(String currentUsername, String targetUsername, String aliasName) {
		currentUser = getUser(currentUsername);
		User targetUser = getUser(targetUsername);

		if (currentUsername != null && targetUser != null) {
			Alias alias = new Alias(currentUser, targetUser, aliasName);
			currentUser.getAliases().put(targetUser, alias);
			return true;
		} else {
			return false;
		}
	}

	public Alias getAlias(String currentUsername, String targetUsername) {
		currentUser = getUser(currentUsername);
		User targetUser = getUser(targetUsername);

		if (currentUsername != null && targetUser != null) {
			return currentUser.getAliases().get(targetUser);
		} else {
			return null;
		}
	}

	public boolean removeUser(String username) {
		if (currentUser != null) {
			dataStorage.getUserRepository().delete(currentUser);
			return true;
		} else {
			return false;
		}
	}
}
