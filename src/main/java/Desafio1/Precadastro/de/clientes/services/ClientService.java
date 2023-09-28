package Desafio1.Precadastro.de.clientes.services;


import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.repositories.ClientRepository;
import Desafio1.Precadastro.de.clientes.services.servicesExceptions.DataIntegrityException;
import Desafio1.Precadastro.de.clientes.services.servicesExceptions.ObjectNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public Client find(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptions(
                "Objeto não encontrado! Id" + id + ", Tipo: " + Client.class.getName()));
    }

    public Client insert(Client obj){
        obj.setId(null);
        return repo.save(obj);
    }
    public Client update(Client obj){
        find(obj.getId());
        return repo.save(obj);
    }
    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possivel excluir um Cliente");
        }
    }
    public List<Client> findAll(){
        return repo.findAll();
    }

//    public Client fromDTO(ClientDto objDto){
//        return new Cliente(objDto.getId(),objDto.getMcc(), objDto.getName(), objDto.getEmail(), null, null, null);
//    }




}




