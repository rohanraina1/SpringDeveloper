package com.sjprogramming.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogramming.restapi.entity.Student;
import com.sjprogramming.restapi.repository.StudentRepository;

@RestController
public class StudentController {
	  @Autowired
	StudentRepository  repo;
	@GetMapping("/students")
     public List<Student> getallStudents(){
		List<Student> students = repo.findAll();
    	 return students;
     }
     
	@PostMapping("/student/add")
	public void createStudent(@RequestBody Student student)
	{
		repo.save(student);
	}
	 @PutMapping("/student/update")
	 public Student updateStudents(@PathVariable int id)
	 {
		 
		 Student student =  repo.findById(id).get();
		 student.setName("Rahul");
		 student.setPercentage(92);
		 repo.save(student);
		 return student;
	 }
}
 