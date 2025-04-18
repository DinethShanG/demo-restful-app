package com.example.demo.dao.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.modal.Student;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentDAOImpl implements StudentDAO {

	private final StudentRepository studentRepository;

	@Override
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Optional<Student> findByName(String name) {
		return studentRepository.findByName(name);
	}
}
