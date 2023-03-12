package ktn.chat.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.HashMap;

import ktn.chat.enums.Gender;

public class User {
	private String userName;
	private String hashPassword;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Gender gender;
	private HashMap<User, Alias> aliases;

	public User(String userName, String password, String firstName, String lastName, LocalDate dateOfBirth,
			Gender gender) {
		this.userName = userName;
		this.hashPassword = passwordEncryption(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.aliases = new HashMap<>();
	}

	public boolean checkPassword(String password) {
		String encryptedPassword = passwordEncryption(password);
		return hashPassword.equals(encryptedPassword);
	}

	private String passwordEncryption(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	// Getters
	public String getUserName() {
		return userName;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public HashMap<User, Alias> getAliases() {
		return aliases;
	}

	// Setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
