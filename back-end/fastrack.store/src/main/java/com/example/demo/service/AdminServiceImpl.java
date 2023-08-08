package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.AdminDetails;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository repository;

	@Override
	public AdminDetails getAdmin(String email, String password)  throws FastrackStoreException {
	
		AdminDetails admin = repository.findByAdminEmailAndAdminPassword(email, password);
		
		if(admin == null) {
			throw new FastrackStoreException("No admin record found!") ;
		}
		return admin;
	}
	
	@Override
	public AdminDetails getUserByName(String username)  throws FastrackStoreException {
		Optional <AdminDetails> admin= repository.findByAdminName(username);
		if(!admin.isPresent()) {
			throw new FastrackStoreException("No admin record found!") ;
		}
		return admin.get();
		
	}
}
