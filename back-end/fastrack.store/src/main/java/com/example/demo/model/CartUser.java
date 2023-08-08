package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	private int productId;
	private int userId;
	public CartUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartUser( int productId, int userId) {
		super();
		//this.cartId = cartId;
		this.productId = productId;
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CartUser [cartId=" + cartId + ", productId=" + productId + ", userId=" + userId + "]";
	}
	
	
	
}
