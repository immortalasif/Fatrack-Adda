package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.UserDetails;
import com.example.demo.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Validated
public class UserController {

	@Autowired
	private UserServiceImpl userservice;
	 

	@PostMapping("/registerUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDetails user ) {
		try {
			UserDetails userFromDb =userservice.addUser(user);	
			return new ResponseEntity<> (userFromDb,HttpStatus.OK);
		}
		catch(FastrackStoreException e) {
			return new ResponseEntity<> (e.getMessage(),HttpStatus.BAD_REQUEST);	
		}
	}
	//return new ResponseEntity<UserDetails> (userservice.addUser(user),HttpStatus.CREATED);	
	
	@PostMapping("/login")
	public ResponseEntity<?> updateAdmin(@RequestBody UserDetails user) throws FastrackStoreException{
		System.out.println(user);
		
		UserDetails userFromDb= userservice.getUser(user.getEmail(), user.getPassword());
		if(userFromDb == null) {
			System.out.println("email id not found");
			return new ResponseEntity<>("please provide correct email id", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(userFromDb,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) throws FastrackStoreException{
		userservice.deleteUser(id);
		return new ResponseEntity<>("successfully unregistered for the services",HttpStatus.OK);
	}
	
	@GetMapping("/getUserName/{username}")
	public ResponseEntity<UserDetails> getUser(@PathVariable  String username) throws FastrackStoreException{ 
		
		UserDetails user= userservice.getUserByName(username);
		return new ResponseEntity<UserDetails>(user,HttpStatus.OK);
		
	}
	
	
}
