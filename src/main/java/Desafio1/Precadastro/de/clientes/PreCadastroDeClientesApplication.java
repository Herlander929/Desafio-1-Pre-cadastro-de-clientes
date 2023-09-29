package Desafio1.Precadastro.de.clientes;

import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.domain.enums.ClientType;
import Desafio1.Precadastro.de.clientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PreCadastroDeClientesApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;




	public static void main(String[] args) {
		SpringApplication.run(PreCadastroDeClientesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


	}



	}

