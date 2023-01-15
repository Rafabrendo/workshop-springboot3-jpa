package com.exejava.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exejava.course.entities.User;

//Isso significa que essa classe é um recurso web que é implementado por um controlador
//rest
@RestController //Anotetion
@RequestMapping(value = "/users") //fiz uma anotetion com um recurso. Um recurso relacionado a entidade User
public class UserResource {
	
	@GetMapping //Para indicar que esse metodo vai ser o metodo que responde a requisição do tipo get do http
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com","9999999", "12345");
		return ResponseEntity.ok().body(u);
				//.ok -> para retornar a resposta com sucesso no http
				//vou retornar o 'corpo' da resposta para o meu usuario u.
	}
}
