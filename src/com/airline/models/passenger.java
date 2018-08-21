package com.airline.models;

import java.util.Date;

public class passenger {
	
	private String firstName;
	private String lastName;
	private Date dob;
	private int Age;
	private Gender gender;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "passenger [firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + ", Age=" + Age + ", gender=" + gender + "]";
	} 
	
	 

}
