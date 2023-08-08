package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.model.ProductDetails;
import com.example.demo.model.UserDetails;
import com.example.demo.service.ProductServiceImpl;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Validated
public class ProductController {

	@Autowired
	
	private ProductServiceImpl productservice;
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id)  throws FastrackStoreException {
		ProductDetails user= productservice.getProduct(id);
		if(user == null) {

		return new ResponseEntity<>("please provide correct user id", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ProductDetails>(user,HttpStatus.OK);		
	}
	
	@PostMapping("/registerProduct")
	public ResponseEntity<?> addProduct(@RequestBody ProductDetails product )  throws FastrackStoreException {
		productservice.addProduct(product);
		return new ResponseEntity<> (HttpStatus.OK);	
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable Integer id,@RequestBody ProductDetails product)  throws FastrackStoreException {
		ProductDetails user= productservice.updateProduct(id, product);
		if(user == null) {
			return new ResponseEntity<>("please provide correct product id", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id)  throws FastrackStoreException {
		productservice.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getAllProducts")
	public List<ProductDetails> getUser()  throws FastrackStoreException {
		
		List<ProductDetails> user= productservice.getAllProducts();
		return user;
		
	}
	
	
}
