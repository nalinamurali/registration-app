package com.au.qld.justice.registration.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;

	@Positive
	@Column(name = "age")
	@NotEmpty(message = "Age is required")
	private Integer age;

	@Email(message = "Invalid Email format", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$)")
	@Column(name = "email")
	@NotEmpty(message = "Email is required")
	private String email;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	
	
	public User() {
		super();
	}

	public User(String name, @Positive int age, String email, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.gender = gender;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
