package com.ltts.demoapplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

	@Id
	private String username;
	private String password;
	private String email;
	private int phone;
	public Member() {
		super();
	}
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Member(String username, String password, String email, int phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member username=" + username + ", pasword=" + password + ", email=" + email + ", phone=" + phone;
	}
}
