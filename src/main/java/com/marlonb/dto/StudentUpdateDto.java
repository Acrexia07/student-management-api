package com.marlonb.dto;

import java.time.LocalDate;

import com.marlonb.entity.enums.StudentGradeLevel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDto {

	@Size(min = 2, max = 100, 
		  message = "Name must be between 2 to 100 characters!")
	private String name;
	
	private StudentGradeLevel gradeLevel;
	
	@Pattern(regexp = "^(\\+63|0)(9[0-9]{9}|[2-8][0-9]{7,8})$", 
			 message = "Must provide valid Philippine mobile number "
					+ "(e.g., +639123456789 or 09123456789)")
	private String contactNumber;
	
	@Email(message = "Format must be a valid email address!")
	private String email;
	
	@Past(message = "Birth date must be a past date!")
	private LocalDate birthDate;	
}
