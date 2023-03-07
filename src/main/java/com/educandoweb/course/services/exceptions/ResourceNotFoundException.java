package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	//criando o metodo ResourceNotFoundxception q RECEBE O ID do OBJETO
	//q tentamos encontrar, mas nao achamos
	public ResourceNotFoundException(Object id) {
		//e vamos retornar a mensagem
		super("Resource not found. Id" + id);
	}
}	