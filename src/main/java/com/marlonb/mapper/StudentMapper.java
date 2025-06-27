package com.marlonb.mapper;

import com.marlonb.dto.StudentRequestDto;
import com.marlonb.dto.StudentResponseDto;
import com.marlonb.dto.StudentUpdateDto;
import com.marlonb.entity.Student;

public class StudentMapper {

	// CREATE: DTO —> ENTITY
	public static Student requestToEntity(StudentRequestDto request) {

		var student = new Student();

		student.setName(request.getName());
		student.setGradeLevel(request.getGradeLevel());
		student.setContactNumber(request.getContactNumber());
		student.setEmail(request.getEmail());
		student.setBirthDate(request.getBirthDate());
		
		return student;
	}
	
	// READ: ENTITY —> DTO
	public static StudentResponseDto responseFromEntity(Student student) {
		
		return new StudentResponseDto(
				student.getId(),
				student.getName(),
				student.getGradeLevel(),
				student.getContactNumber(),
				student.getEmail(),
				student.getBirthDate());
	}
	
	// UPDATE: ENTITY —> DTO
	public static void applyUpdate(Student student, StudentUpdateDto updateRequest) {
		
		if (updateRequest.getName() != null) {
			student.setName(updateRequest.getName());
		}
		if (updateRequest.getGradeLevel() != null) {
			student.setGradeLevel(updateRequest.getGradeLevel());
		}
		if (updateRequest.getContactNumber() != null) {
			student.setContactNumber(updateRequest.getContactNumber());
		}
		if (updateRequest.getEmail() != null) {
			student.setEmail(updateRequest.getEmail());
		}
		if (updateRequest.getBirthDate() != null) {
			student.setBirthDate(updateRequest.getBirthDate());
		}

	}
	
}
