package com.exejava.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exejava.course.entities.User;

//Não vou precisar criar a implementação especifica dessa interface porque o spring data jpa já 
//tem uma implementação padrão para essa interface. Além disso, dps que eu defino o JpaRepository
//ele tbm já tem uma implementação padrão
public interface UserRepository extends JpaRepository<User, Long> {
	

}
