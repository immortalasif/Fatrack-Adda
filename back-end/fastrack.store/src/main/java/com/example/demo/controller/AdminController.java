package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.AdminDetails;
import com.example.demo.model.UserDetails;
import com.example.demo.service.AdminServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Validated
public class AdminController {

	@Autowired
	private AdminServiceImpl adminservice;
	
	@PostMapping("/adminlogin")
	public ResponseEntity<?> updateAdmin(@RequestBody AdminDetails user)  throws FastrackStoreException {
		System.out.println(user);
		
		AdminDetails userFromDb= adminservice.getAdmin(user.getAdminEmail(), user.getAdminPassword());
		if(userFromDb == null) {
			System.out.println("email id not found");
			return new ResponseEntity<>("please provide correct email id", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(userFromDb,HttpStatus.OK);
		
	}
	@GetMapping("/getAdminName/{username}")
	public ResponseEntity<AdminDetails> getUser(@PathVariable  String username)  throws FastrackStoreException {
		
		AdminDetails user= adminservice.getUserByName(username);
		return new ResponseEntity<AdminDetails>(user,HttpStatus.OK);
		
	}
	
}
