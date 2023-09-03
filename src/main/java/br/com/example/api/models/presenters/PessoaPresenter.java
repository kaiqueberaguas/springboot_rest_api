package br.com.example.api.models.presenters;

import java.time.LocalDate;
import java.util.UUID;

import br.com.example.api.models.Pessoa;

public class PessoaPresenter {
    
    private UUID codigo;

    private String nome;

    private LocalDate dataNascimento;

    private EnderecoPresenter endereco;

    private String documento;

    private String tipoDocumento;

    public PessoaPresenter() {
    }

    public PessoaPresenter(Pessoa pessoa) {
        if(pessoa != null){
            this.nome = pessoa.getNome();
            this.codigo = pessoa.getCodigo();
            this.documento = pessoa.getDocumento();
            this.tipoDocumento = pessoa.getTipoDocumento();
            this.dataNascimento = pessoa.getDataNascimento();
            
            if(pessoa.getEndereco() != null)
                this.endereco = new EnderecoPresenter(pessoa.getEndereco());
        }
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

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

    public EnderecoPresenter getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoPresenter endereco) {
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

    

}