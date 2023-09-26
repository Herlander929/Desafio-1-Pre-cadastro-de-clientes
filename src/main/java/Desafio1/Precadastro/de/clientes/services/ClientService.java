package Desafio1.Precadastro.de.clientes.services;


import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.repositories.ClientRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository repo;

    public Client find(Integer id) {
        Optional<Client> obj = repo.findById(id);
        if(obj == null){
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id);
        }

        return obj;

    }

}
