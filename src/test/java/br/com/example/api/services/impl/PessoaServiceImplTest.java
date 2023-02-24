package br.com.example.api.services.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.example.api.models.Pessoa;

public class PessoaServiceImplTest {

    private UUID codigoPessoa = UUID.randomUUID();
    private UUID codigoPessoaInexistente = UUID.randomUUID();

    private Pessoa pessoa;

    private PessoaServiceImpl service;

    public PessoaServiceImplTest() {

        this.pessoa = new Pessoa();
        this.pessoa.setCodigo(codigoPessoa);
        this.pessoa.setDataNascimento(LocalDate.of(2000, 10, 13));
        this.pessoa.setNome("Mavis");
        this.pessoa.setDocumento("01234567890");
        this.pessoa.setTipoDocumento("CPF");

        Map<UUID, Pessoa> pessoaMap = new HashMap<>();
        pessoaMap.put(codigoPessoa, this.pessoa);
        this.service = new PessoaServiceImpl(pessoaMap);
    }

    @Test
    public void test_buscarPorCodigo() {
        var pessoaResponse = this.service.buscarPorCodigo(codigoPessoa);
        Assertions.assertNotNull(pessoaResponse);
        Assertions.assertEquals(this.pessoa.getNome(), pessoaResponse.getNome());
        Assertions.assertEquals(this.pessoa.getDocumento(), pessoaResponse.getDocumento());
        Assertions.assertEquals(this.pessoa.getTipoDocumento(), pessoaResponse.getTipoDocumento());
        Assertions.assertEquals(this.pessoa.getDataNascimento(), pessoaResponse.getDataNascimento());
    }

    @Test
    public void test_buscarPorCodigo_pessoaNaoCadastrada() {
        var pessoaResponse = this.service.buscarPorCodigo(codigoPessoaInexistente);
        Assertions.assertNull(pessoaResponse);
    }

    @Test
    public void test_listar() {
        var response = this.service.listar();
        Assertions.assertNotNull(response);
        Assertions.assertTrue(!response.isEmpty());
    }

    @Test
    public void test_criar() {
        var pessoaNova = new Pessoa();
        pessoaNova.setDataNascimento(LocalDate.of(2000, 10, 13));
        pessoaNova.setNome("Katarina");
        pessoaNova.setDocumento("444444444");
        pessoaNova.setTipoDocumento("CPF");

        var response = this.service.criar(pessoaNova);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getCodigo());
        Assertions.assertEquals(pessoaNova.getNome(), response.getNome());
        Assertions.assertEquals(pessoaNova.getDocumento(), response.getDocumento());
        Assertions.assertEquals(pessoaNova.getTipoDocumento(), response.getTipoDocumento());
        Assertions.assertEquals(pessoaNova.getDataNascimento(), response.getDataNascimento());
    }

    @Test
    public void test_criar_requestNulo() {
        Pessoa pessoaNova = null;
        Assertions.assertDoesNotThrow(() -> this.service.criar(pessoaNova));
    }

    @Test
    public void test_atualizar() {
        var pessoaNova = new Pessoa();
        pessoaNova.setCodigo(this.codigoPessoa);
        pessoaNova.setDataNascimento(LocalDate.of(2000, 10, 13));
        pessoaNova.setNome("Katarina");
        pessoaNova.setDocumento("444444444");
        pessoaNova.setTipoDocumento("CPF");

        var response = this.service.atualizar(pessoaNova);

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getCodigo());
        Assertions.assertEquals(pessoaNova.getCodigo(), response.getCodigo());
        Assertions.assertEquals(pessoaNova.getNome(), response.getNome());
        Assertions.assertEquals(pessoaNova.getDocumento(), response.getDocumento());
        Assertions.assertEquals(pessoaNova.getTipoDocumento(), response.getTipoDocumento());
        Assertions.assertEquals(pessoaNova.getDataNascimento(), response.getDataNascimento());
    }

    @Test
    public void test_atualizar_pessoaInexistente() {
        var pessoaNova = new Pessoa();
        pessoaNova.setCodigo(this.codigoPessoaInexistente);

        var response = this.service.atualizar(pessoaNova);

        Assertions.assertNull(response);        
    }

    @Test
    public void test_excluir() {
        var response = this.service.excluir(this.codigoPessoa);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(this.pessoa.getNome(), response.getNome());
    }
    
    @Test
    public void test_excluir_pessoaInexistente() {
        var response = this.service.excluir(this.codigoPessoaInexistente);
        Assertions.assertNull(response);
    }

}
