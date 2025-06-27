package com.marlonb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marlonb.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
