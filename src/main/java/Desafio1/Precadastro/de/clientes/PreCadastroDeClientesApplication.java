package Desafio1.Precadastro.de.clientes;

import Desafio1.Precadastro.de.clientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreCadastroDeClientesApplication {

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PreCadastroDeClientesApplication.class, args);
	}

}
