package com.sefamertkaya.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sefamertkaya.dao.AdminDAO;
import com.sefamertkaya.entity.Admin;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	public void create(Admin admin) {
		
		adminDAO.create(admin);
		
	}
	
	public void update(Admin admin) {
		
		adminDAO.update(admin);
		
	}

	public void delete(Admin admin) {
	
	adminDAO.delete(admin);
	
}
	
	public Admin controlAdmin(Admin admin) {
		
		return adminDAO.loginControl(admin.getEmail(),admin.getPassword());
		
	}
	

	public Admin getFindById(Long id) {
		
		return adminDAO.getFindById(id);
		
	}
	
	
	public ArrayList<Admin> getAll(){
		
		return adminDAO.getAll();
	}
	
	
	
}
