package Desafio1.Precadastro.de.clientes.domain;

import Desafio1.Precadastro.de.clientes.domain.enums.ClientType;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mcc; // "Merchant Category Code"

    private String nome;


    private String razaoSocial;

   //@Size(max = 50)
    private String nomeContato;

    //@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    private String emailContato;

    @Enumerated(EnumType.STRING)
    private ClientType tipoCliente;

    private String cnpj; // para Pessoa Jurídica

    private String cpf; // para Pessoa Física

    public Client(){}

    public Client(Long id, String mcc, String nome, String razaoSocial, String nomeContato, String emailContato, ClientType tipoCliente,String cnpj, String cpf) {
        this.id = id;
        this.mcc = mcc;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.nomeContato = nomeContato;
        this.emailContato = emailContato;
        this.tipoCliente = tipoCliente;
        this.cnpj = cnpj;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public ClientType getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(ClientType tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



}
