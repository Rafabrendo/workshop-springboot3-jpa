package com.exejava.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exejava.course.entities.Order;
import com.exejava.course.services.OrderService;


@RestController 
@RequestMapping(value = "/orders") 
public class OrderResource {
	
	@Autowired //Para isto funcionar a classe OrderService tem que estar registrada como um componente do spring 
	private OrderService service;
	
	@GetMapping 
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);			
	}
	
	@GetMapping(value = "/{id}") //vai indicar que a requisição vai aceitar um id dentro da url
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
