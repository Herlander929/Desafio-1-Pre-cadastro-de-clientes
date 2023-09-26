package Desafio1.Precadastro.de.clientes.repositories;

import Desafio1.Precadastro.de.clientes.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
