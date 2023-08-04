package com.spring.studentmanagementsystem.dao;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.studentmanagementsystem.entitys.Admin;
import com.spring.studentmanagementsystem.repo.AdminRepo;

@Repository
public class AdminDAO {
@Autowired
private AdminRepo adminrepo;

public Admin saveAdmin(Admin admin) {
	return adminrepo.save(admin);
}

public Admin findAdminById(int adminid) {
	Optional<Admin> optional=adminrepo.findById(adminid);
	if(optional.isEmpty()) {
		return null;
	}else {
		return optional.get();
	}
}

public Admin updateAdminById(int adminid, Admin admin) {
	Optional<Admin> optional=adminrepo.findById(adminid);
	if(optional.isEmpty()) {
		return null;
	}else {
		admin.setAdminid(adminid);
		return adminrepo.save(admin);
	}
}

public Admin deleteAdminByid(int adminid) {
	Optional<Admin> optional=adminrepo.findById(adminid);
	if(optional.isEmpty()) {
		return null;
	}else {
		adminrepo.deleteById(adminid);
		return optional.get();
	}

}
}
