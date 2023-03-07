package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//classe de configuração é uma classe auxiliar q vai fazer algumas alterações 
//na aplicacao classe de configuração para o perfil de test
	//o @CONFIGURATION serve para dizer q e uma class de CONFIGURACAO
@Configuration
	//no Profile é para dizer que essa CLASSE é ESPECIFICA para o PERFIL de TEST
	//vamos ter q por o PROFILE... TEST pois no APPLICATION.PROPERTIES nos informamos
	//q essa é uma APLICACAO de TEST com a linha spring.profiles.active=test
@Profile("test")
	//com essa CLASSE TESTCONFIG nos vamos ADD ALGUNS DADOS de TEST no BANCO
	//a INTERFACE CommandLineRunner cria o METODO RUN
public class TestConfig implements CommandLineRunner{
	//chamando a classe UserRepository para fazer uma INJECAO de DEPEDENCIA e
	//poder assim ADD dados no BANCO
	
	//declarando a DEPEDENCIA de UserRepository
		//com o AUTOWIRED nos vamos instanciar uma DEPEDENCIA de USERREPOSITORY
		//dentro desta CLASSE TESTCONFIG
	@Autowired
	private UserRepository userRepository;
	
	
	//tudo q for colocado dentro do METODO RUN, vai RODAR quando a APLICACAO
	//for EXECUTADA
	@Override
	public void run(String... args) throws Exception {
		//aqui nos vamos INSTANCIAR 2 OBJETOS do tipo USUARIO
		//para fazer os TESTES na aplicação...
			//esses USUARIOS vao ser CAD no BANCO DE DADOS H2... o ID deles e NULL
			//pq é o BANCO de vai DEFINIR
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		//salvando eles no BANCO...
		//chamando o OBJETO userREPOSITORY que é um OBJETO do TIPO USERREPOSITORY
		//classe q tem acesso aos DADOS/BANCO
		//chamando o metodo SAVEALL no qual nos passamos uma LISTA com os 2 USERS acima
		//o U1 e U2
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
	
}
