package com.infoseek.bankingDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoseek.bankingDemo.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByStatus(String studentStatus);
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByAgeBetween(int startAge,int endAge);
}
