package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//criando a CLASSE/entidade USER... com a INTERFACE SERIALIZABLE... Q serve para transformar
//OBJETOS em CADEIA de BYTES... Isso serve para trafegar DADOS na rede...
//
//@ENTITY diz q vai ser CRIADO UMA TABLE NO BANCO COM O MESMO NOME Q A CLASS
//NO CASO USER...
@Entity

@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@JsonIgnore
	//Colocando a ANOTATION ONETOMANY.... 1 para MUITOS... Assim ao acessarmos um CLIENTE
	//podemos ver TODOS os PEDIDOS feito por 1 USUARIO, e entre PARENTESES nos dizemos q
	//no ORDER ele ta MAPEADO como CLIENT, assim nos vamos PEGAR TODOS os ORDER q sao do
	//mesmo CLIENT
	@OneToMany(mappedBy = "client")
	//aqui estamos declarando uma LISTA de ORDER/PEDIDO... OU SEJA um USUARIO pode
	//ter VARIOS PEDIDOS... essa lista de pedido vamos chamar ela de ORDERS
		//e colocamos um NEW ARRAYLIST para iniciar essa lista
	private List<Order> orders = new ArrayList<>();
	
	
	public User() {	
	}

 
	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public List<Order> getOrders() {
		return orders;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
	
	
	
}
