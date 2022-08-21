package com.accenture.lkm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer studentId;
	private String studentName;
	private double percentage;
	private Integer age;
	public StudentEntity() {
		super();
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", percentage=" + percentage
				+ ", age=" + age + "]";
	}
	public StudentEntity(Integer studentId, String studentName, double percentage, Integer age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.percentage = percentage;
		this.age = age;
	}
}
