package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.Card;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CardRepository;

@Service
public class ServiceImpl {

	@Autowired
	public AdminRepository adminRepository;
	
	@Autowired
	public CardRepository cardRepository;
	
	public void addAdmin(Admin ad) {
		adminRepository.save(ad);
		
	}
	
	public Admin getAdmin(int id) {
		
		return adminRepository.findById(id).get();
	}
	
	
}
