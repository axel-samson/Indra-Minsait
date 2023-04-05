package br.com.emprestimominsait.emprestimo.model;

import br.com.emprestimominsait.emprestimo.dto.ClienteDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Entity
public class ClienteModel {

    @NotBlank
    private String nome;

    @Id
    @CPF
    @Column(unique = true) //utilizar em dado único
    private String cpf;

    @NotBlank
    private String telefone;

    @NotNull
    private BigDecimal rendimentalMensal;

    @Cascade(CascadeType.ALL) //força a organização dos atributos para salvar.(exp: aloca atributos numa id e salva)
    @OneToOne
    @JoinColumn(name = "id_do_endereco_model")
    private EnderecoModel enderecoModel;

    public ClienteModel() {
    }

    public ClienteModel(String nome, String cpf, String telefone, BigDecimal rendimentalMensal, EnderecoModel enderecoModel) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rendimentalMensal = rendimentalMensal;
        this.enderecoModel = enderecoModel;
    }

    public EnderecoModel getEnderecoModel() {
        return enderecoModel;
    }

    public void setEnderecoModel(EnderecoModel enderecoModel) {
        this.enderecoModel = enderecoModel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getRendimentalMensal() {
        return rendimentalMensal;
    }

    public void setRendimentalMensal(BigDecimal rendimentalMensal) {
        this.rendimentalMensal = rendimentalMensal;
    }

    public ClienteDto toDto() {
        return new ClienteDto(nome, cpf, telefone, enderecoModel.toDto(), rendimentalMensal);
    }

}


