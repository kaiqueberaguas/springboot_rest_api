package br.com.example.api.controllers.parameters;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.example.api.models.Pessoa;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PessoaParameter {

    private String nome;

    private LocalDate dataNascimento;

    private EnderecoParameter endereco;

    private String documento;

    private String tipoDocumento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EnderecoParameter getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoParameter endereco) {
        this.endereco = endereco;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Pessoa toModel() {
        var pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setDocumento(this.documento);
        pessoa.setTipoDocumento(this.tipoDocumento);
        pessoa.setDataNascimento(this.dataNascimento);
        if (this.endereco != null)
            pessoa.setEndereco(this.endereco.toModel());
        return pessoa;
    }
}
