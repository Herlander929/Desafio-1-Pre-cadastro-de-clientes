package Desafio1.Precadastro.de.clientes.services;


import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository repo;

    public Optional<Client> find(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj;
    }
    }



