package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//criando o UserRESOURCE que disponibiliza um RECURSO WEB correspondente a ENTIDADE/class USER 
//que vai disponibilizar 2 ENDPOINTS para nos PEGAR/RECUPERAR os usuarios CADASTRADOS
//e tbm o usuario informando o ID dele...
@RestController
//como o recurso q vamos requerer e relacionado a USERS(UserResource) entao o caminho é
// /users... Ou seja quando DIGITARMOS localhost:8080/USERS no navegador vai chamar esse metodo
@RequestMapping(value = "/users")
public class UserResource {
	
	//metodo FINDALL do tipo ResponseEntity que é um ENDPOINT para acessar os usuarios... 
	 //esse  METODO ResponseEntity, VAI RETORNAR um VALOR do tipo USER
			//o GETMAPPING e para dizer q responde a REQUISICAO GET DE HTTP
	@GetMapping
	public ResponseEntity<User> findAll(){
		//instanciando um OBJ do tipo USER chamado de U
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "123456");	
		//retornando... o RESPONSE ENTITY OK. e no CORPO/BODY passando o OBJETO U q criamos ali
		//em cima
		return ResponseEntity.ok().body(u);
	}
}
