package com.spring.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.studentmanagementsystem.dao.AdminDAO;
import com.spring.studentmanagementsystem.dao.StudentDAO;
import com.spring.studentmanagementsystem.entitys.Admin;
import com.spring.studentmanagementsystem.entitys.Student;
@Service
public class AdminService {
	
	@Autowired
	private AdminDAO admindao;
	@Autowired
	private StudentDAO studentdao;
	
	public Admin saveAdmin(Admin admin) {
		return admindao.saveAdmin(admin);
	}
	
	public Admin findAdminbyid(int adminid) {
		return admindao.findAdminById(adminid);
	}
	
	public Admin updateAdmin(int adminid, Admin admin) {
		return admindao.updateAdminById(adminid, admin);
	}

	public Admin deleteAdmin(int adminid) {
		Admin admin=admindao.deleteAdminByid(adminid);
		if(admin!=null) {
			List<Student> students=admin.getStudents();
			admindao.deleteAdminByid(adminid);
			for(Student student:students) {
				studentdao.deleteStudent(student);
			}
			
			return admin;
		}else {
			return null;
		}
	}
}
