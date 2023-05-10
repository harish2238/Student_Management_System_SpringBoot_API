package com.spring.studentmanagementsystem.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.studentmanagementsystem.entitys.Admin;
import com.spring.studentmanagementsystem.entitys.Student;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	@Query(value = "select a.students from Admin a where a.adminid=?1")
	public Optional<List<Student>> getStudents(int adminid);

}
