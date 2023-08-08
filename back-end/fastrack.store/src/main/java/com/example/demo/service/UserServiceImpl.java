package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserDetailsRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDetailsRepository repository; 
	
	@Override
	public UserDetails addUser(UserDetails user) throws FastrackStoreException{
		// TODO Auto-generated method stub
		Optional<UserDetails> getUser=repository.findByEmail(user.getEmail());
		if(getUser.isPresent()) {
		
			throw new FastrackStoreException("user email-id already exist");
		}
		return repository.save(user);
	}

	
	@Override
	public UserDetails getUser(String email,String password) throws FastrackStoreException {
		// TODO Auto-generated method stub
		UserDetails user= repository.findByEmailAndPassword(email,password);
		
	
		if(user == null) {
			throw new FastrackStoreException("no user with these datials found");
		}
		
		return user;
	}

	@Override
	public UserDetails getUserByName(String name) throws FastrackStoreException {
		// TODO Auto-generated method stub
		Optional <UserDetails> user= repository.findByName(name);
		return user.get();
	}

	@Override
	public UserDetails updateUserPassword(Integer id,String newpassword) throws FastrackStoreException {
		Optional <UserDetails> optuser= repository.findById(id);
		
		UserDetails user = optuser.get();
		
		if(user != null) {
			user.setPassword(newpassword);
		}
		repository.save(user);
		return user == null ? null : repository.findById(id).get();
	}

	@Override
	public void deleteUser(Integer id) throws FastrackStoreException{
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}


	
	

}
