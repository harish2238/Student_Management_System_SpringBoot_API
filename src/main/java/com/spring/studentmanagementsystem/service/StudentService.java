package com.spring.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.studentmanagementsystem.dao.AdminDAO;
import com.spring.studentmanagementsystem.dao.StudentDAO;
import com.spring.studentmanagementsystem.entitys.Admin;
import com.spring.studentmanagementsystem.entitys.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentdao;
	@Autowired
	private AdminDAO admindao;
	
	public Student saveStudent(Student student, int adminid) {
		Admin admin=admindao.findAdminById(adminid);
		List<Student> students = admin.getStudents();
		students.add(student);
		Student student1=studentdao.saveStudent(student);
		admindao.saveAdmin(admin);
		return student1;
	}
	
	public Student findStudent(int studentid) {
		return studentdao.findStudentById(studentid);
	}
	
	public Student updateStudent(int studentid,Student student) {
		return studentdao.updateStudentById(studentid, student);
	}
	
	public Student deleteStudent(int studentid, int adminid) {
		Student student=studentdao.findStudentById(studentid);
		if(student!=null) {
			Admin admin=admindao.findAdminById(adminid);
			if(admin!=null) {
				List<Student> students = admin.getStudents();
				students.remove(student);
				admindao.updateAdminById(adminid, admin);
				studentdao.deleteStudent(student);
				return student;
			}else {
				return null;
			}
			
			
		}else {
			return null;
		}
	}
	
	public List<Student> getAllStudents(int adminid){
		return studentdao.getAllStudents(adminid);
	}
	
}
