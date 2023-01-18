package com.exejava.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exejava.course.entities.Category;
import com.exejava.course.services.CategoryService;


@RestController 
@RequestMapping(value = "/categories") 
public class CategoryResource {
	
	@Autowired //Para isto funcionar a classe CategoryService tem que estar registrada como um componente do spring 
	private CategoryService service;
	
	@GetMapping 
	public ResponseEntity<List<Category>> findAll(){
		//ResponseEntity<Category> findAll()
		//Category u = new Category(1L, "Maria", "maria@gmail.com","9999999", "12345"); //instanciação manual
		//return ResponseEntity.ok().body(u);
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok().body(list);			
	}
	
	@GetMapping(value = "/{id}") //vai indicar que a requisição vai aceitar um id dentro da url
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
