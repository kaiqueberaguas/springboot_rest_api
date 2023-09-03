package br.com.example.api.integrationTests;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import br.com.example.api.models.parameters.EnderecoParameter;
import br.com.example.api.models.parameters.PessoaParameter;
import br.com.example.api.models.presenters.PessoaPresenter;

@Profile("integrations")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PessoaCrudIT {

    private final String rota = "/api/v1/pessoas";

    private PessoaParameter parameter;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setup() {

        this.parameter = new PessoaParameter();
        this.parameter.setNome("Floriano Peixoto");
        this.parameter.setDocumento("01234567890");
        this.parameter.setTipoDocumento("CPF");
        this.parameter.setDataNascimento(LocalDate.of(1990, Month.APRIL, 15));

        var enderecoParameter = new EnderecoParameter();
        enderecoParameter.setBairro("Vila mariana");
        enderecoParameter.setCep("08006-100");
        enderecoParameter.setCidade("São Paulo");
        enderecoParameter.setEstado("São Paulo");
        enderecoParameter.setNumeroCasa(550);
        enderecoParameter.setPais("Brasil");
        enderecoParameter.setRua("Rua do meio");

        this.parameter.setEndereco(enderecoParameter);
    }

    @Test
    public void test_crud_pessoa() {

        this.validarBaseVazia();

        this.criarPessoa();

        this.conferirDadosCadastrados();

        this.atualizarDados();

    }

    private void validarBaseVazia() {
        var response = this.restTemplate.getForEntity(this.rota, PessoaPresenter[].class);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    private void criarPessoa() {
        var response = this.restTemplate.postForEntity(this.rota, this.parameter, PessoaPresenter.class);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    private void conferirDadosCadastrados() {
        var response = this.restTemplate.getForEntity(this.rota, PessoaPresenter[].class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        var body = response.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals(1, body.length);
        Assertions.assertEquals(this.parameter.getNome(), body[0].getNome());
    }

    private void atualizarDados() {
        var response = this.restTemplate.getForEntity(this.rota, PessoaPresenter[].class);   
        var body = response.getBody();
        Assertions.assertNotNull(body);
        var pessoaAnterior = body[0];
        Assertions.assertNotNull(pessoaAnterior);
        
        var codigoPessoa = pessoaAnterior.getCodigo();

        var rotaPorId = this.rota + "/"+codigoPessoa;

        this.parameter.setNome("Teste atualizacao");

        var request = new HttpEntity<>(this.parameter);
        
        this.restTemplate.exchange(rotaPorId, HttpMethod.PUT, request, PessoaPresenter.class);
        
        
        
        var pessoaAtualizada = this.restTemplate.getForEntity(rotaPorId, PessoaPresenter.class);
        var bodyNovo = pessoaAtualizada.getBody();
        Assertions.assertNotNull(bodyNovo);
        Assertions.assertNotEquals(pessoaAnterior.getNome(), bodyNovo.getNome());
    }

}
