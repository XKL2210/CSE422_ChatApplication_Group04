package KTN.chat.models;

import java.sql.Date;

public class User {
	private String fisrtName;
	private String lastName;
	private String hashPassword;
	private String gender;
	private Date dateOfBirth;
	
	private User(String firstName, String lastName, 
			String hashPassword, String gender, 
			Date dateOfBirth) {
		this.fisrtName = firstName;
		this.lastName = lastName;
		this.hashPassword = hashPassword;
		this.gender = gender;
	}
}
