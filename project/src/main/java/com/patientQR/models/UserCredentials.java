package com.patientQR.models;

public class UserCredentials {
    private String username; 
    private String dateOfBirth; 

 
    
    /** Constructeur
	 * 
	 */
	public UserCredentials() {
		super();
	}

	/** Constructeur
	 * @param username
	 * @param dateOfBirth
	 */
	public UserCredentials(String username, String dateOfBirth) {
		super();
		this.username = username;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
