package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ProductDetails;


public interface ProductrRepository extends JpaRepository<ProductDetails, Integer>{

}
