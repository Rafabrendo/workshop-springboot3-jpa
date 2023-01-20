package com.exejava.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.exejava.course.entities.User;
import com.exejava.course.repositories.UserRepository;
import com.exejava.course.resources.exceptions.DatabaseException;
import com.exejava.course.services.exceptions.ResourceNotFoundException;

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
		//return obj.get(); //Essa operação vai retornar o objeto desse tipo q estiver dentro do optional
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); 
	}
	
	public User insert(User obj) {
		return repository.save(obj); //o save por padrão já retorna o objeto salvo
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateDate(entity, obj);
		return repository.save(entity);
	}
	
	//Não vou atualizar o id e nem o password
	private void updateDate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
