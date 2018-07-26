package com.aj_feereport.student.bean;

import java.io.Serializable;

public class StudentBean implements Serializable {
	private int StuRoll;
	private String name;
	private String email;
	private String course;
	private int fee;
	private int paid;
	private int due;
	private String address;
	private String city;
	private String state;
	private String country;
	private String phone;
	public int getStuRoll() {
		return StuRoll;
	}
	public void setStuRoll(int stuRoll) {
		StuRoll = stuRoll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public int getDue() {
		return due;
	}
	public void setDue(int due) {
		this.due = due;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "StudentBean [StuRoll=" + StuRoll + ", name=" + name
				+ ", email=" + email + ", course=" + course + ", fee=" + fee
				+ ", paid=" + paid + ", due=" + due + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", country="
				+ country + ", phone=" + phone + "]";
	}
	public StudentBean(int stuRoll, String name, String email, String course,
			int fee, int paid, int due, String address, String city,
			String state, String country, String phone) {
		super();
		StuRoll = stuRoll;
		this.name = name;
		this.email = email;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
	}

	public StudentBean() {
		// TODO Auto-generated constructor stub
	}

	

}
