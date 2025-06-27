package com.marlonb.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.marlonb.dto.StudentUpdateDto;
import com.marlonb.entity.Student;
import com.marlonb.mapper.StudentMapper;
import com.marlonb.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository repository;

	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}
	
	// CREATE: Add new student by id
	public Student savedStudentData (Student newStudentData) {
		return repository.save(newStudentData);
	}
	
	// READ: Retrieve all student data
	public List<Student> retrieveAllStudentData () {
		return repository.findAll();
	}
	
	// READ: Retrieve selected student data by id
	public Student retrieveStudentDataById (long id) {
		
		return repository.findById(id).orElseThrow(
				() -> new NoSuchElementException
						(String.format("There's no such id%d exist.", id)));
	}
	
	// UPDATE: Modify selected student data by id
	public Student updateStudentDataById (long id, StudentUpdateDto updateDto) {
		
		// find the selected student id
		Student selectedStudent = retrieveStudentDataById(id);
		
		// Update modifiable fields
		StudentMapper.applyUpdate(selectedStudent, updateDto);
	
		return repository.save(selectedStudent);
	}
	
	// DELETE: Remove selected student data by id
	public void deleteStudentDataByid (long id) {
		repository.deleteById(id);
	}
}
