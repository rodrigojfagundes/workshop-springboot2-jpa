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
//ID.......... o @Service e para dizer q essa classe e um SERVICE do SRING
//e assim ela podera ser injetada com o AUTOWIRED...
@Service
public class UserService {
	
	//Depedencia para a INTERFACE USERREPOSITORY, q iremos chamar de REPOSITORY
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
	
	//criando o metodo FINDBYID para retornar um USUARIO/USER q corresponde a ID passada
	public User findById(Long id) {
		//chamando o nosso OBJETO REPOSITORY do tipo USERREPOSITORY que HERDA a CLASSE
		//JPAREPOSITORY... E essa CLASSE JPAREPOSITORY tem um METODO que é o FINDBYID
		//Dai nos CHAMAMOS o METODO FINDBYID q esta no JPAREPOSITORY e pedimos para trazer
		//o USERS da ID q foi passada pelo USUARIO...
			//e ele(USER) vai ser armazenado dentro do OBJETO OBJ que é um OBJETO q recebe
			//um USER e é do tipo OPTIONAL
		Optional<User> obj = repository.findById(id);
		//retornando o OBJ
		return obj.get();
	}
}
