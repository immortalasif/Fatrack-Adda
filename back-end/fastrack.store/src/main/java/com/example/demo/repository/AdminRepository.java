package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AdminDetails;
import com.example.demo.model.UserDetails;

public interface AdminRepository extends JpaRepository<AdminDetails,Integer>{

public	AdminDetails findByAdminEmailAndAdminPassword(String email, String password);

public Optional<AdminDetails> findByAdminName(String username);

}
