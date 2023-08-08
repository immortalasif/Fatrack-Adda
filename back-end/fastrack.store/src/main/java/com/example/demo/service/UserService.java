package com.example.demo.service;

import com.example.demo.exception.FastrackStoreException;
import com.example.demo.model.UserDetails;

public interface UserService {

public UserDetails getUserByName(String name)  throws FastrackStoreException;

public UserDetails updateUserPassword(Integer id,String newpassword)  throws FastrackStoreException;

public void deleteUser(Integer id)  throws FastrackStoreException;

public UserDetails getUser(String email, String password)  throws FastrackStoreException;

UserDetails addUser(UserDetails user)  throws FastrackStoreException;


}
