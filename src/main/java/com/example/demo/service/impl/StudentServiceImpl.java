package com.example.demo.service.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.modal.Student;
import com.example.demo.service.StudentService;
import com.example.demo.validator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentDAO studentDAO;
	private final StudentValidator validator;

	@Autowired
	public StudentServiceImpl(StudentDAO studentDAO, StudentValidator validator) {
		this.studentDAO = studentDAO;
		this.validator = validator;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDAO.findAll();
	}

	@Override
	public Student createStudent(String name) {
		validator.validateName(name);
		Student student = new Student();
		student.setName(name.trim());
		return studentDAO.save(student);
	}

	@Override
	public Student updateStudent(Long id, String name) {
		validator.validateId(id);
		validator.validateName(name);
		
		Student student = findStudentById(id);
		student.setName(name.trim());
		return studentDAO.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		validator.validateId(id);
		findStudentById(id);
		studentDAO.deleteById(id);
	}

	@Override
	public Optional<Student> getStudentById(Long id) {
		validator.validateId(id);
		return Optional.of(findStudentById(id));
	}
	
	private Student findStudentById(Long id) {
		return studentDAO.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
	}
}
