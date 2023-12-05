package com.masai.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student){
			
		Student savedStudent = studentService.addStudent(student);
		
		return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable Integer roll){
			
		Student fetchedtudent = studentService.getStudentByRoll(roll);
		
		return new ResponseEntity<Student>(fetchedtudent,HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler(){
			
		List<Student> students = studentService.getAllStudent();
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentByRollHandler(@PathVariable Integer roll){
			
		Student student = studentService.deleteStudentByRoll(roll);
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentDetailsHandler(@RequestBody Student student,
																@PathVariable Integer roll){
			
		Student updatedStudent = studentService.updateStudentDetails(roll, student);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
	

}
