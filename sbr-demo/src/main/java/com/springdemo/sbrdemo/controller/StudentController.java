package com.springdemo.sbrdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.sbrdemo.model.Student;
import com.springdemo.sbrdemo.service.iStudentService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	@Autowired
	private iStudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<>(studentService.getStudents(),HttpStatus.FOUND);
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@PutMapping("/update/{Id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable Long Id) {
		return studentService.updateStudent(student, Id);
		
	}
	
	@DeleteMapping("/delete/{Id}")
	public void deleteStudent(@PathVariable Long Id) {
		studentService.deleteStudent(Id);
	}
	
	@GetMapping("/student/{Id}")
	public Student getStudentById(@PathVariable Long Id) {
		return studentService.getStudentById(Id);
	}
}
