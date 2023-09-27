package Desafio1.Precadastro.de.clientes.domain;

import Desafio1.Precadastro.de.clientes.domain.enums.ClientType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4, max = 4, message = "MCC deve ter exatamente 4 caracteres.")
    private String mcc; // "Merchant Category Code"

    @Size(max = 50)
    private String name;


    @Size(max = 50)
    private String razaoSocial;

   @Size(max = 50)
    private String nomeContato;

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    private String emailContato;

    private String cpfcontato;

    //@Enumerated(EnumType.STRING)
    private Integer tipoCliente;

    private String cnpj; // para Pessoa Jurídica

    private String cpf; // para Pessoa Física

    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
    private String emailPessoa;

    public Client(){}

    public Client(ClientType tipoCliente, String mcc, String name, String razaoSocial, String nomeContato, String emailContato,String cnpj, String cpf, String cpfcontato, String emailPessoa) {
        this.mcc = mcc;




        if(tipoCliente == ClientType.PESSOAFISICA){
             this.tipoCliente = (tipoCliente == null) ? null : tipoCliente.getCod();
             this.cpf = cpf;
             this.name = name;
             this.emailPessoa = emailPessoa;
        } else if(tipoCliente == ClientType.PESSOAJURIDICA){
            this.tipoCliente = (tipoCliente == null) ? null : tipoCliente.getCod();
            this.cnpj = cnpj;
            this.razaoSocial = razaoSocial;
            this.cpfcontato = cpfcontato;
            this.emailContato = emailContato;
            this.nomeContato = nomeContato;
        }
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
        if (mcc != null && mcc.length() == 4) {
            this.mcc = mcc;
        } else {
            throw new IllegalArgumentException("MCC deve ter exatamente 4 caracteres.");
        }
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

    public ClientType getTipoCliente() {

        return ClientType.toEnum(tipoCliente);
    }

    public void setTipoCliente(ClientType tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        String cnpjNumerico = cnpj.replaceAll("[^0-9]", "");


        int length = cnpjNumerico.length();
        if (length < 14) {
            StringBuilder cnpjFormatado = new StringBuilder("0".repeat(14 - length));
            cnpjFormatado.append(cnpjNumerico);
            this.cnpj = cnpjFormatado.toString();
        } else if (length == 14) {

            this.cnpj = cnpjNumerico;
        } else {
            this.cnpj = cnpjNumerico.substring(0, 14);
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null) {

            cpf = cpf.replaceAll("[^0-9]", "");
            this.cpf = String.format("%011d", Long.parseLong(cpf));
        } else {
            this.cpf = null;
        }
    }

    public String getCpfcontato() {
        return cpfcontato;
    }

    public void setCpfcontato(String cpfcontato) {
        if (cpfcontato != null) {

            cpf = cpfcontato.replaceAll("[^0-9]", "");
            this.cpfcontato = String.format("%011d", Long.parseLong(cpfcontato));
        } else {
            this.cpfcontato = null;
        }
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(mcc, client.mcc) && Objects.equals(name, client.name) && Objects.equals(razaoSocial, client.razaoSocial) && Objects.equals(nomeContato, client.nomeContato) && Objects.equals(emailContato, client.emailContato) && Objects.equals(cpfcontato, client.cpfcontato) && Objects.equals(tipoCliente, client.tipoCliente) && Objects.equals(cnpj, client.cnpj) && Objects.equals(cpf, client.cpf) && Objects.equals(emailPessoa, client.emailPessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mcc, name, razaoSocial, nomeContato, emailContato, cpfcontato, tipoCliente, cnpj, cpf, emailPessoa);
    }
}
