package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

//criando o ProductRESOURCE que disponibiliza um RECURSO WEB correspondente a ENTIDADE/class PRODUCT 
//que vai disponibilizar 2 ENDPOINTS para nos PEGAR/RECUPERAR os produtos CADASTRADOS
//e tbm o produto informando o ID dele...
@RestController
//como o recurso q vamos requerer e relacionado a PRODUCTS(ProductResource) entao o caminho é
// /products... Ou seja quando DIGITARMOS localhost:8080/PRODUCTS no navegador vai chamar esse metodo
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	//metodo FINDALL do tipo ResponseEntity que é um ENDPOINT para acessar os produtos... 
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){		
		List<Product> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")

	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
