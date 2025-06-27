package com.marlonb.dto;

import java.time.LocalDate;

import com.marlonb.entity.enums.StudentGradeLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class StudentResponseDto {

	private long id;
	
	private String name;
	
	private StudentGradeLevel gradeLevel;
	
	private String contactNumber;
	
	private String email;
	
	private LocalDate birthDate;	
}
