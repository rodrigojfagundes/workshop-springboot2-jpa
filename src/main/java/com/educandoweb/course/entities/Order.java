package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//criando a nossa CLASSE/ENTIDADE PEDIDOS/ORDER
@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;

	//implementando os ATRIBUTOS/VARIAVEIS basicas... do PEDIDO
	//colocando o @ID para dizer q o ID e a chave primeria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
		//declarando uma VARIAVEL CLIENT do tipo USER... Para sabermos qual é o 
		//USUARIO/CLIENTE q esta fazendo o PEDIDO
	//colocando a ANNOTATION MANYTOONE... Pois é MUITOS (ORDER/PEDIDO) para UM CLIENTE/USER
	@ManyToOne
	//Annotation JoinColumn recebe a CHAVE ESTRANGEIRA q tera no BANCO q é o ID do cliente
	//q fez o PEDIDO
	@JoinColumn(name = "client_id")
	private User client;
	
	
	public Order() {}


	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}


	public User getClient() {
		return client;
	}


	public void setClient(User client) {
		this.client = client;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}