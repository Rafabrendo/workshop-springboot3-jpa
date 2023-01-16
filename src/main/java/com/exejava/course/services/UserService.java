package com.exejava.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exejava.course.entities.User;
import com.exejava.course.repositories.UserRepository;

@Service //É uma classe de serviço então dei preferencia ao @Service .
public class UserService {
	
	@Autowired //Para que o spring faça a injeção de dependencia de forma transparente
	private UserRepository repository;
	
	//Metodo para retornar todos os usuarios do banco de dados
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); //Essa operação vai retornar o objeto desse tipo q estiver dentro do optional
	}
	

}
