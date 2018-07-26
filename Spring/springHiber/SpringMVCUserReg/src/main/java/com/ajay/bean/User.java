package com.ajay.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="userreg")
public class User {
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Id
	@Column(name="id")
	@Size(max=5)
	 @NotEmpty(message="id shold not be empty")
int id;
	 @NotEmpty(message=" sname shold not be empty")
String name;
	 @NotEmpty(message=" pass word shold not be empty")
String password;
}
