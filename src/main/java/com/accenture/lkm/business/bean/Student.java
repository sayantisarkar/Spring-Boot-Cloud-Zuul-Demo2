package com.accenture.lkm.business.bean;

public class Student {
	private String studentName;
	private Integer studentId;
	private double percentage;
	private Integer age;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Student(String studentName, Integer studentId, double percentage, Integer age) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.percentage = percentage;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", percentage=" + percentage
				+ ", age=" + age + "]";
	}	
}
