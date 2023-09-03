package br.com.example.api.models.presenters;

import br.com.example.api.models.Endereco;

public class EnderecoPresenter {

    private Integer numeroCasa;

    private String complementoCasa;

    private String cep;

    private String rua;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

    public EnderecoPresenter() {
    }

    public EnderecoPresenter(Endereco endereco) {
        if(endereco != null){
            this.cep = endereco.getCep();
            this.rua = endereco.getRua();
            this.pais = endereco.getPais();
            this.bairro = endereco.getBairro();
            this.cidade = endereco.getCidade();
            this.estado = endereco.getEstado();
            this.numeroCasa = endereco.getNumeroCasa();
            this.complementoCasa = endereco.getComplementoCasa();
        }
    }

    public Integer getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(Integer numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getComplementoCasa() {
        return complementoCasa;
    }

    public void setComplementoCasa(String complementoCasa) {
        this.complementoCasa = complementoCasa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}