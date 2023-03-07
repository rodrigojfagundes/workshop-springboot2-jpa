package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	//
	//
	//
	//fazendo associacao entre PRODUCT e CATEGORY
		//1 PRODUTO tem VARIAS CATEGORIAS
	//NAO vamos usar LIST, mas SIM um SET/CONJUNTO... Pois queremos garantir q
	//um PRODUCT NAO vai estar 2 VEZES ou MAIS na mesma CATEGORY
	//
	//mapear as classes PRODUCT e CATEGORY para aparecer a tabela de associacao 
	//aparece no BANCO.... A Associacao de MUITOS PRODUTOS para MUITAS CATEGORIAS, 
	//e MUITAS CATEGORIAS para MUITOS PRODUTOS... Associacao MUITOS para MUITOS com 
	//a JOINTABLE
	@ManyToMany
	//
	//no Annotation JOINTABLE nos vamos falar QUAL O NOME da TABELA...
	//e o JOINCOLUMNS para falar e QUAIS vao ser as CHAVES ESTRANGEIRAS/(ID) q vamos 
	//ASSOCIAR ENTRE A TABELA DE PRODUCT E CATEGORY
	@JoinTable(name = "tb_product_category", 
	joinColumns = @JoinColumn(name = "product_id"),
	//o INVERSEJOINCOLUMN e para definirmos qual é a CHAVE ESTRANGEIRA(ID) da outra
	//ENTIDADE/CLASSE/TABELA... no caso CATEGORY
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	

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
