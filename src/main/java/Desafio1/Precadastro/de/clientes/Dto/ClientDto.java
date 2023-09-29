package Desafio1.Precadastro.de.clientes.Dto;

import Desafio1.Precadastro.de.clientes.domain.Client;
import Desafio1.Precadastro.de.clientes.domain.enums.ClientType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;


@Data
public class ClientDto implements Serializable {
    private Integer id;

    @Size(min = 4, max = 4, message = "MCC deve ter exatamente 4 caracteres.")
    private String mcc;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(max = 50, message = "O tamanho deve ter até 50 caracteres")
    private String name;


    @Size(max = 50)
    private String razaoSocial;

    @Size(max = 50)
    private String nomeContato;

//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Email(message = "Email inválido")
//    //@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    private String emailContato;

    private String cpfcontato;

//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Email(message = "Email inválido")
//    //@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    private String emailPessoa;

    private Integer tipoCliente;

    private String cnpj; // para Pessoa Jurídica

    private String cpf;
    public ClientDto(){}


    public ClientDto(Client obj) {
            tipoCliente = obj.getTipoCliente();
            id = obj.getId();
            mcc = obj.getMcc();
            name = obj.getName();
            cpf = obj.getCpf();
            emailPessoa = obj.getEmailPessoa();
            razaoSocial = obj.getRazaoSocial();
            cnpj = obj.getCnpj();
            nomeContato = obj.getNomeContato();
            emailContato = obj.getEmailContato();
            cpfcontato = obj.getCpfcontato();
            }





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCpfcontato() {
        return cpfcontato;
    }

    public void setCpfcontato(String cpfcontato) {
        this.cpfcontato = cpfcontato;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public Integer getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Integer tipoCliente) {
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
