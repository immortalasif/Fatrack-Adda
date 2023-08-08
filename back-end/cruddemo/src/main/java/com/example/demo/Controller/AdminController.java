package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.Card;
import com.example.demo.service.ServiceImpl;

@RestController
public class AdminController {

	@Autowired
	private ServiceImpl serviceImpl;
	
	@PostMapping("/register")
	public ResponseEntity<?> addAdmin(@RequestBody Admin admin){
		
////		List<Card> list= new ArrayList<Card>();
////		list.add(new Card(101,"debit"));
////		list.add(new Card(102,"credit"));
////		list.add(new Card(107,"debit"));
//		
//		Admin admin = new Admin();
//		admin.setAdminId(1);
//		admin.setName("prava");
//		admin.setCard(list);
		
		serviceImpl.addAdmin(admin);
		
		return null;
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable Integer id){
		
		return new ResponseEntity<>(serviceImpl.getAdmin(id), HttpStatus.OK);
		
	}
	
}
