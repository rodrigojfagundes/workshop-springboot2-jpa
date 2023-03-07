package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

//criando o CategoryRESOURCE que disponibiliza um RECURSO WEB 
//correspondente a ENTIDADE/class Category 

@RestController
//como o recurso q vamos requerer e relacionado a CATEGORY(CategoryResource) entao 
//o caminho é /category... Ou seja quando DIGITARMOS localhost:8080/CATEGORIES no 
//navegador vai chamar esse metodo
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	//metodo FINDALL do tipo ResponseEntity que é um ENDPOINT para acessar as categorias... 
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){		
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//criando um ENDPOIT/METODO para Buscar a Categoria por ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
