package Desafio1.Precadastro.de.clientes.resources;

import Desafio1.Precadastro.de.clientes.Dto.ClientDto;
import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClientResource {

    @Autowired
    private ClientService service;

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<Client> find(@PathVariable Integer id) {
        Client obj = service.find(id);
        return ResponseEntity.ok().body(obj);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Client obj) {
        //Cliente obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created((uri)).build();
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Void> update(@Valid @RequestBody ClientDto objDto, @PathVariable Integer id){
//        //Client obj = service.fromDTO(objDto);
//        obj.setId(id);
//        obj = service.update(obj);
//        return ResponseEntity.noContent().build();
//
//    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT , consumes = "application/json")
    public ResponseEntity<Void> update(@RequestBody Client obj, @PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete (@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<ClientDto>> findAll() {
        List<Client> list = service.findAll();
        List<ClientDto> listDto = list.stream().map(ClientDto::new).collect(Collectors.toList());
        //List<ClientDto> listDto = list.stream().map(obj -> new ClientDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }
}
