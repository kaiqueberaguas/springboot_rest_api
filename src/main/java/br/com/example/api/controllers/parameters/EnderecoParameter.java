package br.com.example.api.controllers.parameters;

import br.com.example.api.models.Endereco;

public class EnderecoParameter {

    private Integer numeroCasa;

    private String complementoCasa;

    private String cep;

    private String rua;

    private String bairro;

    private String cidade;

    private String estado;

    private String pais;

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

    public Endereco toModel(){
        var endereco = new Endereco();
        endereco.setCep(this.cep);
        endereco.setRua(this.rua);
        endereco.setPais(this.pais);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);
        endereco.setEstado(this.estado);
        endereco.setNumeroCasa(this.numeroCasa);
        endereco.setComplementoCasa(this.complementoCasa);
        return endereco;
    }

}
