package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

//
//classe orderService
//teremos duas OPERAÇÔES/METODOS basicos... Buscar TODOS PEDIDOS, e BUSCAR PEDIDOS por
//ID.......... o @Service e para dizer q essa classe e um SERVICE do SPRING
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	//metodo para RETORNAR TODOS PEDIDOS DO BANCO
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	//criando o metodo FINDBYID para retornar um PEDIDO/ORDER q corresponde a ID passada
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
