package com.Student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.entity.Students;
import com.Student.repository.StudentRepo;


@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public void addStudent(Students std) {
		studentRepo.save(std);
	}
	
	public List<Students> getAllStudent(){
		return studentRepo.findAll();
	}
	
	public Students getStudentById(int id) {

		Optional<Students> e = studentRepo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;

	}
	public void deleteStudent(Integer id) {
		studentRepo.deleteById(id);
	}
}
