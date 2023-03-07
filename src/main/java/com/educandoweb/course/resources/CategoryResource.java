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
//que vai disponibilizar 2 ENDPOINTS para nos PEGAR/RECUPERAR as categorias CADASTRADAS
//e tbm a categoris informando a ID dela...
@RestController

@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){		

		List<Category> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	

	@GetMapping(value = "/{id}")

	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}