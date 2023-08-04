package com.spring.studentmanagementsystem.controller;

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
import com.spring.studentmanagementsystem.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminservice;
	
	
	@PostMapping
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminservice.saveAdmin(admin);
	}
	
	@GetMapping
	public Admin findAdminByid(@RequestParam int adminid) {
		return adminservice.findAdminbyid(adminid);
	}
	
	@PutMapping
	public Admin updateAdmin(@RequestParam int adminid,@RequestBody Admin admin) {
		return adminservice.updateAdmin(adminid, admin);
	}
	
	@DeleteMapping
	public Admin deleteAdmin(@RequestParam int adminid) {
		return adminservice.deleteAdmin(adminid);
	}

}
