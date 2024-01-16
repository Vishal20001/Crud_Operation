package com.springdemo.sbrdemo.service;

import java.util.List;

import com.springdemo.sbrdemo.model.Student;

public interface iStudentService {
	
	Student addStudent(Student student);
	List<Student> getStudents();
	Student updateStudent(Student student,Long id);
	Student getStudentById(Long id);
	public void deleteStudent(Long id);
}
