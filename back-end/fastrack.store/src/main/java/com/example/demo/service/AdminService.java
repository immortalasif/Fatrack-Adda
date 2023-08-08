package com.example.demo.service;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.AdminDetails;
import com.example.demo.model.UserDetails;

public interface AdminService {
	
	//public AdminDetails getUser(String email, String password);

	AdminDetails getAdmin(String email, String password) throws FastrackStoreException;
	public AdminDetails getUserByName(String username)  throws FastrackStoreException;
}
