package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

//classe de configuração é uma classe auxiliar q vai fazer algumas alterações 
//na aplicacao classe de configuração para o perfil de test
	//o @CONFIGURATION serve para dizer q e uma class de CONFIGURACAO
@Configuration
@Profile("test")
	//com essa CLASSE TESTCONFIG nos vamos ADD ALGUNS DADOS de TEST no BANCO
	//a INTERFACE CommandLineRunner cria o METODO RUN
public class TestConfig implements CommandLineRunner{
	//chamando a classe UserRepository para fazer uma INJECAO de DEPEDENCIA e
	//poder assim ADD dados no BANCO
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public void run(String... args) throws Exception {
		//aqui nos vamos INSTANCIAR 2 OBJETOS do tipo USUARIO
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Instanciando 3 OBJETOS(o1, o2 e o3) do tipo PEDIDO 
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		
		//salvando eles no BANCO...
		//chamando o OBJETO userREPOSITORY que é um OBJETO do TIPO USERREPOSITORY
		userRepository.saveAll(Arrays.asList(u1, u2));

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}	
}
