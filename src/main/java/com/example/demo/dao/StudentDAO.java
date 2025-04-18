package com.example.demo.dao;

import com.example.demo.modal.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
	Student save(Student student);
	Optional<Student> findById(Long id);
	List<Student> findAll();
	void deleteById(Long id);
	Optional<Student> findByName(String name);
}
