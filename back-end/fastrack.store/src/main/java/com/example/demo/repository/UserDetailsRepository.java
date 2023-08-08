package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{


	Optional<UserDetails> findByName(String name);

	

	UserDetails findByEmailAndPassword(String email, String password);



	Optional<UserDetails> findByEmail(String email);
	

}
