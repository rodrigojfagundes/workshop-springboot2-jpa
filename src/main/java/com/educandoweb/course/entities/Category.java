package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "tb_category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	
	//fazendo associacao entre CATEGORY e PRODUCT
			//1 CATEGORIA pd ter VARIOS PRODUTOS
		//NAO vamos usar LIST, mas SIM um SET/CONJUNTO... Pois queremos garantir q
		//um CATEGORY NAO vai estar 2 VEZES ou MAIS na mesmo PRODUCT
		//
		//ou seja estamos fazendo um SET/conjunto de PRODUCT q vamos chamar de products
		//colocamos o NEW HASHSET para ela comecar NULLA, mas INSTANCIADA
		//e colocamos o HASHSET, pois o SET é uma INTERFACE, e NAO pd ser INSTANCIADO
		//mas o HASHSET pode
		//
	//colocando uma REFERENCIA para o MAPEAMENTO q fizemos na class PRODUCT
		//no MAPPEDBY nos colocamos o NOME da COLECAO q temos na outra CLASS (classe
		//PRODUCT) e o nome da COLECAO q vamos fazer REFERENCIA e CATEGORIES
		//pois esse e o NOME DO SET/COLECAO q ta em PRODUCT
			//JsonIgnore e para nao dar loop
	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>();
	
	public Category() {}
	
	
	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
