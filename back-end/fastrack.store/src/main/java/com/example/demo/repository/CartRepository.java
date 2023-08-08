package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CartUser;
//import com.example.demo.model.UserDetails;
import com.example.demo.model.ProductDetails;

public interface CartRepository  extends JpaRepository<CartUser, Integer> {

	List<CartUser> findByUserId(Integer userId);

	//CartUser findByUserIdAndProductId(Integer userId, Integer productId);

	CartUser findByUserIdAndProductIdAndCartId(Integer userId, Integer productId, Integer cartId);
	//List<CartUser> findByUserIdAndProductIdAndCartId(Integer userId, Integer productId);

	List<CartUser> findByUserIdAndProductId(Integer userId, Integer productId);

}
