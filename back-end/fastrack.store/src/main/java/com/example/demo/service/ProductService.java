package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.ProductDetails;
import com.example.demo.model.UserDetails;

public interface ProductService {
	
	public  void addProduct(ProductDetails productDetails) throws FastrackStoreException;

	public ProductDetails getProduct(Integer productId) throws FastrackStoreException;

	public List<ProductDetails> getAllProducts() throws FastrackStoreException;

	public ProductDetails updateProduct(Integer productId,ProductDetails product) throws FastrackStoreException;

	public void deleteProduct(Integer productId) throws FastrackStoreException;
}
