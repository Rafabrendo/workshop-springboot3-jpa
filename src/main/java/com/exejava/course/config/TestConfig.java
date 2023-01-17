package com.exejava.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exejava.course.entities.Order;
import com.exejava.course.entities.User;
import com.exejava.course.repositories.OrderRepository;
import com.exejava.course.repositories.UserRepository;

@Configuration
@Profile("test")//esse nome tem que ser igual ao que está no application.properties
public class TestConfig implements CommandLineRunner{
	//a interface CommandLineRunner vai fazer a execução quando o programa for executado
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		//Tudo que for colocado dentro desse metodo vai ser executado quando a aplicação for iniciada
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2)); 
		//para salvar eu chamo o objeto userRepository e o metodo saveAll, passando o Arrays.asList
		//passando os dois objetos(u1 e u2).
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
