package com.exejava.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exejava.course.entities.Product;
import com.exejava.course.repositories.ProductRepository;

@Service //É uma classe de serviço então dei preferencia ao @Service .
public class ProductService {
	
	@Autowired //Para que o spring faça a injeção de dependencia de forma transparente
	private ProductRepository repository;
	
	//Metodo para retornar todos os usuarios do banco de dados
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get(); //Essa operação vai retornar o objeto desse tipo q estiver dentro do optional
	}
	

}
