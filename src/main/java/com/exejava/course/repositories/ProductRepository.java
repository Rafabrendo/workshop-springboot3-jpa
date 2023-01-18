package com.exejava.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exejava.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
