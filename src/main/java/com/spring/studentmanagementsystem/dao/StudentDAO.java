package com.spring.studentmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.studentmanagementsystem.entitys.Admin;
import com.spring.studentmanagementsystem.entitys.Student;
import com.spring.studentmanagementsystem.repo.AdminRepo;
import com.spring.studentmanagementsystem.repo.StudentRepo;

@Repository
public class StudentDAO {
	@Autowired
	private StudentRepo studentrepo;
	@Autowired
	private AdminRepo adminrepo;

	public Student saveStudent(Student student) {
		return studentrepo.save(student);
	}
	
	public Student findStudentById(int studentid) {
		Optional<Student> optional=studentrepo.findById(studentid);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}

	public Student updateStudentById(int studentid, Student student) {
		Optional<Student> optional=studentrepo.findById(studentid);
		if(optional.isEmpty()) {
			return null;
		}else {
			student.setStudentid(studentid);
			return studentrepo.save(student);
		}
	}
	
	public Student deleteStudent(Student student) {
		studentrepo.delete(student);
		return student;
	}
	
	public Student DeleteStudent(int studentid) {
		Optional<Student> optional=studentrepo.findById(studentid);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}
	
	public List<Student> getAllStudents(int adminid){
		Optional<List<Student>> optional= adminrepo.getStudents(adminid);
		
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}


}
