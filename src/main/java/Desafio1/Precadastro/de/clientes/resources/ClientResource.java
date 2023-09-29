package Desafio1.Precadastro.de.clientes.resources;

import Desafio1.Precadastro.de.clientes.Dto.ClientDto;
import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
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

    @PostMapping(value = "/insert")
    public ResponseEntity<Client> insert(@Valid @RequestBody Client obj) {
        //Client obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created((uri)).build();
        //return response;
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Void> update(@Valid @RequestBody ClientDto objDto, @PathVariable Integer id){
//        //Client obj = service.fromDTO(objDto);
//        obj.setId(id);
//        obj = service.update(obj);
//        return ResponseEntity.noContent().build();
//
//    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT , consumes = "application/json", produces = "application/json")
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
        //List<ClientDto> listDto = list.stream().map((Client t) -> new ClientDto()).collect(Collectors.toList());
        List<ClientDto> listDto = list.stream().map(obj -> new ClientDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }
    @RequestMapping( value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClientDto>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name")String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC")String direction){
        Page<Client> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClientDto> listDto = list.map((Client t) -> new ClientDto());
        return ResponseEntity.ok().body(listDto);
    }
}
