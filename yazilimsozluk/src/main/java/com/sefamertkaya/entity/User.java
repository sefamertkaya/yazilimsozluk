package com.sefamertkaya.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String email;
	private String username;
	private String password;
	private String gender;
	private Long good = 0l;
	private Long bad = 0l;
	private String keyreg;
	private Date regDate = new Date();

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getregDate() {
		return regDate;
	}

	public void setregDate(Date date) {
		this.regDate = date;
	}

	public Long getGood() {
		return good;
	}

	public void setGood(Long good) {
		this.good = good;
	}

	public Long getBad() {
		return bad;
	}

	public void setBad(Long bad) {
		this.bad = bad;
	}

	public String getKeyreg() {
		return keyreg;
	}

	public void setKeyreg(String keyreg) {
		this.keyreg = keyreg;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", gender=" + gender + ", good=" + good + ", bad=" + bad + ", keyreg=" + keyreg + ", regDate="
				+ regDate + "]";
	}

}
