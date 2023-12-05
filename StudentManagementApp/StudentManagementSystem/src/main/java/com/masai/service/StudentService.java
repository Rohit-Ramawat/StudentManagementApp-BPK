package com.masai.service;

import java.util.List;

import com.masai.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	
	public Student getStudentByRoll(Integer roll);
	
	public List<Student> getAllStudent();
	
	public Student deleteStudentByRoll(Integer roll);
	
	//whole student update
	public Student updateStudentDetails(Integer roll,Student student);
	

}
