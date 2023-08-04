package com.spring.studentmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.studentmanagementsystem.entitys.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
