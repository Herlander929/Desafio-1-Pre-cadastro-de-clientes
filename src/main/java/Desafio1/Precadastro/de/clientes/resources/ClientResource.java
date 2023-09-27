package Desafio1.Precadastro.de.clientes.resources;

import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Client>> find(@PathVariable Integer id) {
        Optional<Client> obj = service.find(id);
        return ResponseEntity.ok().body(obj);

    }

}
