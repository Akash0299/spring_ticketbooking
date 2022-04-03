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
	public Member(String uname, String pswd, String email, int phone) {
		super();
		this.username = uname;
		this.password = pswd;
		this.email = email;
		this.phone = phone;
	}
	public String getUname() {
		return username;
	}
	public void setUname(String uname) {
		this.username = uname;
	}
	public String getPswd() {
		return password;
	}
	public void setPswd(String pswd) {
		this.password = pswd;
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
	@Override
	public String toString() {
		return "Member username=" + username + ", pasword=" + password + ", email=" + email + ", phone=" + phone;
	}
}
