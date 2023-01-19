package com.exejava.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exejava.course.entities.User;
import com.exejava.course.services.UserService;


@RestController 
@RequestMapping(value = "/users") 
public class UserResource {
	
	@Autowired //Para isto funcionar a classe UserService tem que estar registrada como um componente do spring 
	private UserService service;
	
	@GetMapping 
	public ResponseEntity<List<User>> findAll(){
		//ResponseEntity<User> findAll()
		//User u = new User(1L, "Maria", "maria@gmail.com","9999999", "12345"); //instanciação manual
		//return ResponseEntity.ok().body(u);
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);			
	}
	
	@GetMapping(value = "/{id}") //vai indicar que a requisição vai aceitar um id dentro da url
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//return ResponseEntity.ok().body(obj);
		//quando se vai retornar um 201 é esperado que a resposta contenha um cabeçalho chamado location contendo o novo 
		//endereço do recurso que eu inserir
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
		
	}
}
