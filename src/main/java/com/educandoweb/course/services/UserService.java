package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//
//classe UserService
//teremos duas OPERAÇÔES/METODOS basicos... Buscar TODOS USUARIOS, e BUSCAR USUARIOS por
//ID.......... o @Service e para dizer q essa classe e um SERVICE do SPRING
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	//metodo para RETORNAR TODOS USUARIOS DO BANCO
	public List<User> findAll(){
		//chamando o nosso OBJETO REPOSITORY do tipo USERREPOSITORY que HERDA a CLASSE
		//JPAREPOSITORY... E essa CLASSE JPAREPOSITORY tem um METODO que é o FINDALL
		//Dai nos CHAMAMOS o METODO FINDALL q esta no JPAREPOSITORY e pedimos para trazer
		//todos USERS cadastrados no BANCO
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
