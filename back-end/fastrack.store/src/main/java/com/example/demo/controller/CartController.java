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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.CartUser;
import com.example.demo.model.ProductDetails;
import com.example.demo.model.UserDetails;
import com.example.demo.service.CartServiceImpl;
import com.example.demo.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Validated
public class CartController {

	@Autowired
	private CartServiceImpl cartService;
	
	//get all products in the cart
	@GetMapping("/getCart/{userId}")
	public ResponseEntity<?>  getCartProducts(@PathVariable  Integer userId)  throws FastrackStoreException {
		
		List<ProductDetails> list1=  cartService.getCartProducts(userId);
		//return new ResponseEntity<ProductDetails>(list1,HttpStatus.OK);
		return new ResponseEntity<>(list1,HttpStatus.OK);
		
	}
	//add to the cart of specific user
	@PostMapping("/addToCart/{userId}/{productId}")
	public ResponseEntity<?> addToCart(@PathVariable  Integer userId,@PathVariable  Integer productId )  throws FastrackStoreException {
		cartService.addItem(userId,productId);
		return new ResponseEntity<> (HttpStatus.OK);	
	}
	
	//deletes the item in the cart
	@DeleteMapping("/deleteItem/{userId}/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer userId,@PathVariable Integer productId)  throws FastrackStoreException {
		cartService.deleteCartProduct(userId,productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//empty cart
	@DeleteMapping("/deleteAllItem/{userId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer userId)  throws FastrackStoreException {
		cartService.deleteAllCartProducts(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
