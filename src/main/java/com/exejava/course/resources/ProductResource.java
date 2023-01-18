package com.exejava.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exejava.course.entities.Product;
import com.exejava.course.services.ProductService;


@RestController 
@RequestMapping(value = "/products") 
public class ProductResource {
	
	@Autowired //Para isto funcionar a classe ProductService tem que estar registrada como um componente do spring 
	private ProductService service;
	
	@GetMapping 
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);			
	}
	
	@GetMapping(value = "/{id}") //vai indicar que a requisição vai aceitar um id dentro da url
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
