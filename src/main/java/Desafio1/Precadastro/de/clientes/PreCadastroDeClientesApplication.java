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
		//Client cli1 = new Client(ClientType.PESSOAJURIDICA, );

		// Instanciando um cliente Pessoa Jurídica (CNPJ)
		Client clienteJuridico = new Client(
				ClientType.PESSOAJURIDICA, // Tipo de cliente (Pessoa Jurídica)
				"1234", // MCC
				"Empresa XYZ", // Nome da Empresa
				"Empresa Razão Social", // Razão Social
				"João Contato", // Nome do Contato
				"joao@empresa.com", // Email do Contato
				"12.345.678/0001-99", // CNPJ
				null, // CPF (não usado para PJ)
				null, // CPF do Contato (não usado para PJ)
				null // Email da Pessoa (não usado para PJ)
		);
//
//		// Instanciando um cliente Pessoa Física (CPF)
//		Client clienteFisico = new Client(
//				ClientType.PESSOAFISICA, // Tipo de cliente (Pessoa Física)
//				"5432", // MCC
//				"João Pessoa", // Nome da Pessoa
//				null, // Razão Social (não usado para PF)
//				null, // Nome do Contato
//				"joao@pessoa.com", // Email do Contato
//				null, // CNPJ (não usado para PF)
//				"12345678900", // CPF
//				null, // CPF do Contato (não usado para PF)
//				null // Email da Empresa (não usado para PF)
//		);
//
		clientRepository.saveAll(Arrays.asList(clienteJuridico));

	}



	}

