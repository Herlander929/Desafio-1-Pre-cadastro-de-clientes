package Desafio1.Precadastro.de.clientes.domain.enums;

import Desafio1.Precadastro.de.clientes.domain.Client;

import java.util.LinkedList;

public class ServiceQueue {

    private LinkedList<Client> Queue = new LinkedList<>();

    public void addClient(Client client){
        Queue.addLast(client);

    }

    public  Client serveNextClient(){
        if (Queue.isEmpty()){
            return  null;
        }
        return Queue.removeFirst();
    }

    public boolean QueueIsEmpty(){
        return Queue.isEmpty();
    }
}
