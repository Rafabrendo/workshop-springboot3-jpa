package com.exejava.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exejava.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}
