package com.masai.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rollNumber;
	
	private String firstName;
	
	private String lastName;
	
	private Major major;
	
	private LocalDate dob;
	
	private LocalDate enrollmentDate;
	
	private String address;

	private String phone;
	
	private Gender gender;

	public Student(String firstName, String lastName, Major major, LocalDate dob, LocalDate enrollmentDate,
			String address, String phone, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.dob = dob;
		this.enrollmentDate = enrollmentDate;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}

	/*
	 {
    "firstName":"",
    "lastName":"",
    "major":"",
    "dob":"",
    "address":"",
    "phone":"",
    "gender":""
}
	 */
}
