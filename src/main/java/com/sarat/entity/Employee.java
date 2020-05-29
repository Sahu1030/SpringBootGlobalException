package com.sarat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id") 
	private int id;
	@Column(name = "emp_name")
	private String fName;
	@Column(name = "age")
	private int age;
	@Column(name = "email")
	private String email;
	@Column(name = "place")
	private String plase;
	
		
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(String fName, int age, String email, String plase) {
		this.fName = fName;
		this.age = age;
		this.email = email;
		this.plase = plase;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPlase() {
		return plase;
	}


	public void setPlase(String plase) {
		this.plase = plase;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", age=" + age + ", email=" + email + ", plase=" + plase
				+ "]";
	}
	
	
	
	

}
