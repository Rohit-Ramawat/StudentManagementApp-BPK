package com.masai.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		
		student.setEnrollmentDate(LocalDate.now());
		
		return studentRepository.save(student);
		
	}

	@Override
	public Student getStudentByRoll(Integer roll) {
		
		Student student = studentRepository.findById(roll)
				.orElseThrow(() -> new StudentException("invalid roll number"));
		
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		
		List<Student> students = studentRepository.findAll();
		
		return students;
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) {
		
		Student student = studentRepository.findById(roll)
				.orElseThrow(() -> new StudentException("invalid roll number"));
		
		studentRepository.delete(student);
		
		return student;
	}

	@Override
	public Student updateStudentDetails(Integer roll, Student student) {
		
		Student savedStudent = studentRepository.findById(roll)
				.orElseThrow(() -> new StudentException("invalid roll number"));
		
		savedStudent.setFirstName(student.getFirstName());
		savedStudent.setLastName(student.getLastName());
		savedStudent.setDob(student.getDob());
		savedStudent.setAddress(student.getAddress());
		savedStudent.setPhone(student.getPhone());
		savedStudent.setGender(student.getGender());
		savedStudent.setMajor(student.getMajor());
		
		return studentRepository.save(savedStudent);
	}




}
