package com.springtut.entities;

public class LoginEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6246356312358617021L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
