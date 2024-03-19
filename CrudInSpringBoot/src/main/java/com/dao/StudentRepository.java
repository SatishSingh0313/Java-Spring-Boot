package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
        
}
