package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Entity class representing an Employee in the application
@Entity
@Table(name="employee")
public class Employee {

	// Primary key for identifying each employee
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	// First name of the employee
	@Column(name="first_name")
	private String firstName;

	// Last name of the employee
	@Column(name="last_name")
	private String lastName;

	// Job position or title of the employee
	@Column(name="position")
	private String position;

	// Age of the employee
	@Column(name="age")
	private int age;

	// Default constructor (required by JPA)
	public Employee() {
	}

	// Constructor to initialize an Employee object with specific attributes
	public Employee(int id, String firstName, String lastName, String position, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.age = age;
	}

	// Getter for employee ID
	public int getId() {
		return id;
	}

	// Setter for employee ID
	public void setId(int id) {
		this.id = id;
	}

	// Getter for first name
	public String getFirstName() {
		return firstName;
	}

	// Setter for first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Getter for last name
	public String getLastName() {
		return lastName;
	}

	// Setter for last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Getter for position
	public String getPosition() {
		return position;
	}

	// Setter for position
	public void setPosition(String position) {
		this.position = position;
	}

	// Getter for age
	public int getAge() {
		return age;
	}

	// Setter for age
	public void setAge(int age) {
		this.age = age;
	}

	// Override toString method to provide a string representation of Employee object
	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", position='" + position + '\'' +
				", age=" + age +
				'}';
	}
}

