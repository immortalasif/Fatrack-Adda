package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.ProductDetails;

public interface CartService {

	List<ProductDetails> getCartProducts(Integer userId) throws FastrackStoreException;
	
	public void addItem(Integer userId,Integer productId) throws FastrackStoreException;
	
	//public void deleteCartProduct(Integer userId, Integer productId,Integer cartId)  throws FastrackStoreException;
	public void deleteCartProduct(Integer userId, Integer productId)  throws FastrackStoreException;

	
}
