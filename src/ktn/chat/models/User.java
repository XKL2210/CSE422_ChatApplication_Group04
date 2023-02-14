package ktn.chat.models;

import java.sql.Date;

public class User {
	private String firstName;
	private String lastName;
	private String hashPassword;
	private String gender;
	private Date dateOfBirth;
	
	private User(String firstName, String lastName, 
			String hashPassword, String gender, 
			Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hashPassword = hashPassword;
		this.gender = gender;
	}
	

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public boolean verifyPasword(String inputPasword) {
		return hashPassword.equalsIgnoreCase(inputPasword);
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    public void setGender(String gender) {
    	this.gender = gender;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
    	this.dateOfBirth = dateOfBirth;
    }
    
    public void setHashPassword(String hashPassword) {
    	this.hashPassword = hashPassword;
    }
}
