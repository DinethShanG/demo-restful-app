package com.example.demo.service;

import com.example.demo.modal.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

	List<Student> getAllStudents();

	Student createStudent(String name);

	Student updateStudent(Long id, String name);

	void deleteStudent(Long id);

	Optional<Student> getStudentById(Long id);
}
