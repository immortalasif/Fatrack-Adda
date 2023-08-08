package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.CartUser;
import com.example.demo.model.ProductDetails;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductrRepository;
import com.example.demo.repository.UserDetailsRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private ProductrRepository productRepository;
	
	@Autowired
	private UserDetailsRepository userRepository; 
	
	@Autowired
	private CartRepository cartRepository; 
	
	@Override
	public List<ProductDetails> getCartProducts(Integer userId)  throws FastrackStoreException {
		
	List<CartUser> userProduct  = cartRepository.findByUserId(userId);
		
		List<ProductDetails> productList = new ArrayList<ProductDetails>();

		
		for (CartUser entries : userProduct) {
			
			Optional<ProductDetails> productInCart =productRepository.findById(entries.getProductId());
			
			if(productInCart.isPresent()) {
			productList.add(productInCart.get());
			
		}}
		
		return productList;
	}

	@Override
	public void addItem(Integer userId,Integer productId)  throws FastrackStoreException {
		// TODO Auto-generated method stub
		CartUser item = new CartUser( productId,userId);
		cartRepository.save(item);
	}
	@Override
	public void deleteCartProduct(Integer userId, Integer productId)  throws FastrackStoreException {
		List<CartUser> item= cartRepository.findByUserIdAndProductId(userId,productId);
		if(item.isEmpty()) {
			return;
		}
		cartRepository.delete(item.get(0));
		
	}

	public void deleteAllCartProducts(Integer userId) {
		List<CartUser> item= cartRepository.findByUserId(userId);
		for (CartUser cartUser : item) {
			cartRepository.delete(cartUser);
		}
		
	}

//	@Override
//	public void deleteCartProduct(Integer userId, Integer productId,Integer cartId) throws FastrackStoreException {
//		// TODO Auto-generated method stub
//		CartUser item= cartRepository.findByUserIdAndProductIdAndCartId(userId,productId,cartId);
//		//List<CartUser> items = cartRepository.findByUserIdAndProductIdAndCartId(userId,productId);
//		cartRepository.delete(item);
//	}
	
	
	
}
