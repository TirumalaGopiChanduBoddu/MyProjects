package com.gopi.bean;

public class Student {

	private String name;
	private int rno;
	private String emailId;
	private String mobileNumber;
	
	public Student(String name, int rno, String emailId, String mobileNumber) {
		super();
		this.name = name;
		this.rno = rno;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", rno=" + rno + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber
				+ "]";
	}
	
	
}
