package com.jerry.entity;

import java.io.Serializable;
import javax.persistence.*;
 
@Entity
@Table(name = "user")
public class User implements Serializable {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String email;
	private String firstname;
	private String lastname;
 
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return this.firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return this.lastname;
	} 
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", email=" + email
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
 
}
