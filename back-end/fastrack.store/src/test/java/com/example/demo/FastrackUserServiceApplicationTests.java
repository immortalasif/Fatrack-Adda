package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserDetailsRepository;
import com.example.demo.service.UserServiceImpl;

@SpringBootTest
public class FastrackUserServiceApplicationTests {
	

	@Mock
	private UserDetailsRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Test
	public void addUserValidTest() throws FastrackStoreException {
		UserDetails user = new UserDetails(1, "John","john@gmail.com", "John123", "CS");
		Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.ofNullable(null));
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assertions.assertEquals(user, userServiceImpl.addUser(user));
	}

	@Test
	public void addUserInValidTest() throws FastrackStoreException {
		UserDetails student = new UserDetails(1,  "John","john@gmail.com", "Dagger", "CS");
		Mockito.when(userRepository.findByEmail(student.getEmail())).thenReturn(Optional.of(student));
		Assertions.assertThrowsExactly(FastrackStoreException.class, () -> userServiceImpl.addUser(student));

	}
	
}
