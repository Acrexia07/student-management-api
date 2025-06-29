package com.marlonb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marlonb.dto.StudentRequestDto;
import com.marlonb.dto.StudentResponseDto;
import com.marlonb.dto.StudentUpdateDto;
import com.marlonb.entity.Student;
import com.marlonb.mapper.StudentMapper;
import com.marlonb.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class StudentController {

	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// CREATE: New student data
	@PostMapping(path ="/students")
	public ResponseEntity<StudentResponseDto> createNewStudentData 
								(@Valid @RequestBody StudentRequestDto requestNewData) {
		
		Student newStudent = StudentMapper.requestToEntity(requestNewData);
		
		Student savedNewStudent = studentService.savedStudentData(newStudent);
		
		StudentResponseDto response = StudentMapper.responseFromEntity(savedNewStudent);
		
		return ResponseEntity.ok(response);
	}
	
	// READ: Single student data
	@GetMapping(path ="/students/{id}")
	public ResponseEntity<StudentResponseDto> retrieveSelectedStudentData (@PathVariable long id) {
		
		Student selectedStudent = studentService.retrieveStudentDataById(id);
		
		if (selectedStudent == null) {
			return ResponseEntity.notFound().build();
		}
		
		StudentResponseDto response = StudentMapper.responseFromEntity(selectedStudent);
		
		return ResponseEntity.ok(response);
	}	
	
	
	// READ: All student data
	@GetMapping(path ="/students")
	public ResponseEntity<List<StudentResponseDto>> retrieveAllStudentData () {
		
		List<Student> students = studentService.retrieveAllStudentData();
		
		List<StudentResponseDto> response 
						= students.stream()
								  .map(StudentMapper::responseFromEntity)
								  .collect(Collectors.toList());
		
		return ResponseEntity.ok(response);
	}
	
	// UPDATE: Selected student data by id
	@PutMapping(path ="/students/{id}")
	public ResponseEntity<StudentResponseDto> removeSelectedStudentData (@PathVariable long id, 
																	    @Valid @RequestBody StudentUpdateDto updateRequest) {
		
		try {
			
			Student updatedStudent = studentService.updateStudentDataById(id, updateRequest);
			
			StudentResponseDto response = StudentMapper.responseFromEntity(updatedStudent);
			
			return ResponseEntity.ok(response);  
			
		}catch (RuntimeException e) {
			return ResponseEntity.notFound().build(); 
		}
	}
	
	// DELETE: Selected student data by id
	@DeleteMapping(path ="/students/{id}")
	public ResponseEntity<Void> createNewStudentData (@PathVariable long id) {
		
		Student selectedStudent = studentService.retrieveStudentDataById(id);
		
		if (selectedStudent == null) {
			return ResponseEntity.notFound().build();
		}
		
		studentService.deleteStudentDataByid(id);
		
		return ResponseEntity.noContent().build();
	}
}
