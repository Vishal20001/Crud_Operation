package com.springdemo.sbrdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.sbrdemo.exception.StudentAlreadyExistsException;
import com.springdemo.sbrdemo.exception.StudentNotFoundException;
import com.springdemo.sbrdemo.model.Student;
import com.springdemo.sbrdemo.repository.StudentRepository;

@Service
public class StudentService implements iStudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public Student addStudent(Student student) {
		
		if(studentAlreadyExits(student.getEmail())) {
			throw new StudentAlreadyExistsException(student.getEmail()+"  Already Exists!");
		}
				return studentRepository.save(student); 
	}

	private boolean studentAlreadyExits(String Email) {
		return studentRepository.findByEmail(Email).isPresent();
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		return studentRepository.findById(id).map(st ->{
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());
			return studentRepository.save(st);
		}).orElseThrow(()->new StudentNotFoundException("Sorry the student could not found"));
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(()->new StudentNotFoundException("Sorry ,No Student found with this Id: "+id));
	}

	@Override
	public void deleteStudent(Long id) {
		
		if(!studentRepository.existsById(id)) {
			throw new StudentNotFoundException("Sorry ,No Student found with this Id: "+id);
		}
		studentRepository.deleteById(id);
	}

}
