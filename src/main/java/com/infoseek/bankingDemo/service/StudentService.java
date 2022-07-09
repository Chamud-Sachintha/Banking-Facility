package com.infoseek.bankingDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoseek.bankingDemo.domain.Student;
import com.infoseek.bankingDemo.repo.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Student saveStudentDetails(Student newStudent) {
		return this.studentRepository.save(newStudent);
	}
	
	public List<Student> getAllStudents(){
		return this.studentRepository.findAll();
	}
	
	public Optional<Student> getStudentDetailsById(long studentId) {
		return this.studentRepository.findById(studentId);
	}
	
	public Student updateStudentDetailsById(long studentId,Student updatedStudentDetails) {
		Student currentStudent = this.studentRepository.getById(studentId);
		
		if(currentStudent != null) {
			currentStudent.setFirstName(updatedStudentDetails.getFirstName());
			currentStudent.setLastName(updatedStudentDetails.getLastName());
			currentStudent.setStatus(updatedStudentDetails.getStatus());
			currentStudent.setContactNo(updatedStudentDetails.getContactNo());
			currentStudent.setAge(updatedStudentDetails.getAge());
		}
		
		return this.studentRepository.save(currentStudent);
	}
	
	public void deleteStudentById(long studentId) {
		this.studentRepository.deleteById(studentId);
	}
	
	public List<Student> getStudentDetailsByStatus(String studentStatus){
		return this.studentRepository.findByStatus(studentStatus);
	}
	
	public List<Student> getStudentDetailsByFirstName(String firstName){
		return this.studentRepository.findByFirstName(firstName);
	}
	
	public List<Student> getStudentDetailsBetweenAge(int startAge,int endAge){
		return this.studentRepository.findByAgeBetween(startAge, endAge);
	}
}
