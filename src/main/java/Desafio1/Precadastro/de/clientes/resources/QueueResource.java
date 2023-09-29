package Desafio1.Precadastro.de.clientes.resources;


import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.domain.enums.ServiceQueue;
import Desafio1.Precadastro.de.clientes.services.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Queue")
public class QueueResource {

    @Autowired
    private QueueService queueService;
    private ServiceQueue queue = new ServiceQueue();

    @PostMapping("/AddCliente")
    public ResponseEntity<String> addClient(@RequestBody Client client){
        queue.addClient(client);
        return ResponseEntity.ok("Cliente adicionado à Fila");
    }

    @GetMapping("/atenderProximoCliente")
    public ResponseEntity<Client> serveNextClient(){
        Client servedClient = queue.serveNextClient();
        if(servedClient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servedClient);

    }

    @GetMapping("/filaVazia")
    public ResponseEntity<String> QueueIsEmpty() {
        boolean empty = queue.QueueIsEmpty();
        if(empty){
            return ResponseEntity.ok("A fila de atendimento está vazia");

        } else {
            return ResponseEntity.ok("A fila de atendimento não está vazia");
        }
    }

    @GetMapping("/obterFila")
    public ResponseEntity<List<Client>> obterFila() {
        List<Client> fila = queueService.getQueue();
        return ResponseEntity.ok(fila);
    }

}
