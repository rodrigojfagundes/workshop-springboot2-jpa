package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

	//criando a CLASSE PRODUCT
//o @ENTITY e para dizer q vai ser CRIADO no BANCO uma TABELA com o MESMO NOME q a CLASSE
//no caso PRODUCT... Ou seja vai ser gerenciado pelo JPA
@Entity
//	o @TABLE e para dizer q VAMOS RENOMEAR a TABELA de PRODUCT para TB_PRODUCT
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
		//declarando os ATRIBUTOS/VARIAVEIS basicos...
	//colocando o @ID para dizer q o ID e a chave primeria
	//@GENERATEDVALUE IDENTITY... e para dizer q a chave é AUTOINCREMENT pelo BANCO
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	//
	//fazendo associacao entre PRODUCT e CATEGORY
		//1 PRODUTO tem VARIAS CATEGORIAS
	//NAO vamos usar LIST, mas SIM um SET/CONJUNTO... Pois queremos garantir q
	//um PRODUCT NAO vai estar 2 VEZES ou MAIS na mesma CATEGORY
	//
	//ou seja estamos fazendo um SET/conjunto de CATEGORIES q vamos chamar de categories
	//colocamos o NEW HASHSET para ela comecar NULLA, mas INSTANCIADA
	//e colocamos o HASHSET, pois o SET é uma INTERFACE, e NAO pd ser INSTANCIADO
	//mas o HASHSET pode
		
		//@TRANSCIENTE e PROVISORIO... impede o JPA de tentar interpretar
	@Transient
	private Set<Category> categories = new HashSet<>();
	
	
	//criando o metodo construtor SEM argumentos
	public Product() {}

	
	//declarando o metodo CONSTRUTOR COM OS ARGUENTOS/variaveis/atributos
	//	MENOS a COLECAO CATEGORIES... Pois o CATEGORIES ja foi INSTANCIADO ali em cima :)
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	
	//criando os GET e SET

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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Set<Category> getCategories() {
		return categories;
	}
	
	
	//criando os metodos HASHCODE e EQUALS para fazer comparacoes
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
