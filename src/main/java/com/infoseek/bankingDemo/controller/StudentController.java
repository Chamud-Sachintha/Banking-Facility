package com.infoseek.bankingDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infoseek.bankingDemo.domain.Student;
import com.infoseek.bankingDemo.service.StudentService;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public Student createStudent(@RequestBody Student newStudent){
		return this.studentService.saveStudentDetails(newStudent);
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		return this.studentService.getAllStudents();
	}
	
	@GetMapping(path = "{studentId}")
	public Optional<Student> getStudentById(@PathVariable long studentId) {
		return this.studentService.getStudentDetailsById(studentId);
	}
	
	@PutMapping(path = "{studentId}")
	public Student updateStudentById(@PathVariable long studentId,@RequestBody Student studentDetails) {
		return this.studentService.updateStudentDetailsById(studentId, studentDetails);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudentById(@PathVariable long studentId) {
		this.studentService.deleteStudentById(studentId);
	}
	
	@GetMapping("status/{status}")
	public List<Student> getStudentByStatus(@PathVariable String status){
		return this.studentService.getStudentDetailsByStatus(status);
	}
	
	@GetMapping("fname/{firstName}")
	public List<Student> getStudentsByFirstName(@PathVariable String firstName){
		return this.studentService.getStudentDetailsByFirstName(firstName);
	}
	
	@GetMapping("/age/{startAge}/{endAge}")
	public List<Student> getStudentsByAgeBetween(@PathVariable int startAge,@PathVariable int endAge){
		return this.studentService.getStudentDetailsBetweenAge(startAge, endAge);
	}
}
