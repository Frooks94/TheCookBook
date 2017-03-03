package edu.ben.models;

public class User {
	private String firstName;
	private String lastName;
	private String pWord;
	private String userName;
	private String email;
	
	public User(String firstName, String lastName, String pWord, String userName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pWord = pWord;
		this.userName = userName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
