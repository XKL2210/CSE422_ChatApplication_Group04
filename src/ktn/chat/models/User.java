package ktn.chat.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;

import ktn.chat.enums.Gender;
import ktn.chat.enums.Role;

public class User {
	private String userName;
    private String hashPassword;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
	//Constructor
    public User(String userName, String password, String firstName, String lastName, LocalDate dateOfBirth, Gender gender) {
        this.userName = userName;
        this.hashPassword = passwordEncryption(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    //Functional Methods
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
    //Getter
    public String getUsername() {
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
    //Setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLocalDate(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void getGender(Gender gender) {
        this.gender = gender;
    }
}
