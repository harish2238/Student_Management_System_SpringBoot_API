package com.spring.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.studentmanagementsystem.entitys.Admin;
import com.spring.studentmanagementsystem.entitys.Student;
import com.spring.studentmanagementsystem.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@PostMapping
	public Student saveStudent(@RequestBody Student student,@RequestParam int adminid) {
		return studentservice.saveStudent(student, adminid);
	}
	
	@GetMapping
	public Student findStudentByid(@RequestParam int studentid) {
		return studentservice.findStudent(studentid);
	}
	
	@PutMapping
	public Student updateStudent(@RequestParam int studentid, @RequestBody Student student) {
		return studentservice.updateStudent(studentid, student);
	}
	
	@DeleteMapping
	public Student deleteStudent(@RequestParam int studentid, @RequestParam int adminid) {
		return studentservice.deleteStudent(studentid, adminid);
	}
	
	@GetMapping("/admin")
	public List<Student> getAllStudents(@RequestParam int adminid){
		return studentservice.getAllStudents(adminid);
	}

}
