package Desafio1.Precadastro.de.clientes.services;


import Desafio1.Precadastro.de.clientes.domain.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class QueueService {

    private Queue<Client> queue = new LinkedList<>();

    public void addClient(Client client){
        queue.add(client);
    }

    public Client serveNextClient(){
        return queue.poll();
    }

    public List<Client> getQueue(){
        return new ArrayList<>(queue);
    }
}
