package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

//criando o OrderRESOURCE que disponibiliza um RECURSO WEB correspondente a ENTIDADE/class ORDER 
//que vai disponibilizar 2 ENDPOINTS para nos PEGAR/RECUPERAR os pedidos CADASTRADOS
//e tbm o pedido informando o ID dele...
@RestController
//como o recurso q vamos requerer e relacionado a ORDER(OrderResource) entao o caminho é
// /orders... Ou seja quando DIGITARMOS localhost:8080/ORDERS no navegador vai chamar esse metodo
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	//metodo FINDALL do tipo ResponseEntity que é um ENDPOINT para acessar os pedidos... 
	 //esse  METODO ResponseEntity, VAI RETORNAR um VALOR do tipo LIST de ORDER
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){		
		//declarando uma LISTA de PEDIDOS, q RECEBE o SERVICO do nosso FINDALL
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//criando um ENDPOIT/METODO para Buscar o PEDIDO por ID
	@GetMapping(value = "/{id}")
	//criando o METODO FINDBYID... do tipo RESPONSEENTITY q vai RETORNAR um ORDER conform o ID passado
	public ResponseEntity<Order> findById(@PathVariable Long id){
		//criando uma VARIAVEL OBJ do TIPO USER q recebe o METODO FINDBYID q ta no
		//JPA que é HERDADO pelo OBJETO SERVICE que é um OBJETO do tipo OrderService(declarado
		//ali em cima)
		Order obj = service.findById(id);
		//retornando o OBJETO/USUARIO encontrado pelo o ID :)
		return ResponseEntity.ok().body(obj);
		
	}
	
}
