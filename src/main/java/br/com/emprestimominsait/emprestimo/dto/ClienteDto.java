package br.com.emprestimominsait.emprestimo.dto;

import br.com.emprestimominsait.emprestimo.model.ClienteModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

//classe para transferir dados de um lugar para o outro
//data transfer object
public class ClienteDto {

    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @NotBlank
    private String telefone;

    @NotNull
    private EnderecoDto endereco;

    @NotNull
    @JsonProperty(value = "rendimento_mensal")
    private BigDecimal rendimentalMensal;

    public ClienteDto(String nome, String cpf, String telefone, EnderecoDto endereco, BigDecimal rendimentalMensal) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.rendimentalMensal = rendimentalMensal;
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

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getRendimentalMensal() {
        return rendimentalMensal;
    }

    public void setRendimentalMensal(BigDecimal rendimentalMensal) {
        this.rendimentalMensal = rendimentalMensal;
    }

    public ClienteModel toModel() {

        return new ClienteModel(nome, cpf, telefone, rendimentalMensal, endereco.toModel());
    }
}
