package com.Student.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int roll_Number;
	private int hindi;
	private int english;
	private int math;
	private int physics;
	private int chamistry;
    private float percentag;
    private String grade;
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
	public int getRoll_Number() {
		return roll_Number;
	}
	public void setRoll_Number(int roll_Number) {
		this.roll_Number = roll_Number;
	}
	public int getHindi() {
		return hindi;
	}
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getPhysics() {
		return physics;
	}
	public void setPhysics(int physics) {
		this.physics = physics;
	}
	public int getChamistry() {
		return chamistry;
	}
	public void setChamistry(int chamistry) {
		this.chamistry = chamistry;
	}
	public float getPercentag() {
		return percentag;
	}
	public void setPercentag(float percentags) {
		this.percentag = percentags;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", roll_Number=" + roll_Number + ", hindi=" + hindi
				+ ", english=" + english + ", math=" + math + ", physics=" + physics + ", chamistry=" + chamistry
				+ ", percentag=" + percentag + ", grade=" + grade + "]";
	}
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
