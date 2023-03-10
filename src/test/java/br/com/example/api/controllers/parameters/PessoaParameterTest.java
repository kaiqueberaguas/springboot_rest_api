package br.com.example.api.controllers.parameters;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaParameterTest {

    @Test
    public void test(){
        var parameter = new PessoaParameter();
        parameter.setDataNascimento(LocalDate.of(2001,03,25));
        parameter.setDocumento("01234567890");
        parameter.setNome("Crisberto Alivado");
        parameter.setTipoDocumento("CNH");
        parameter.setEndereco(new EnderecoParameter());
        var model = parameter.toModel();

        Assertions.assertEquals(parameter.getNome(), model.getNome());
        Assertions.assertEquals(parameter.getDocumento(), model.getDocumento());
        Assertions.assertEquals(parameter.getTipoDocumento(), model.getTipoDocumento());
        Assertions.assertEquals(parameter.getDataNascimento(), model.getDataNascimento());
        Assertions.assertEquals(parameter.getEndereco(), model.getEndereco());
    }
    
    @Test
    public void test_null(){
        var parameter = new PessoaParameter();
        var model = parameter.toModel();

        Assertions.assertEquals(parameter.getNome(), model.getNome());
        Assertions.assertEquals(parameter.getDocumento(), model.getDocumento());
        Assertions.assertEquals(parameter.getTipoDocumento(), model.getTipoDocumento());
        Assertions.assertEquals(parameter.getDataNascimento(), model.getDataNascimento());
        Assertions.assertEquals(parameter.getEndereco(), model.getEndereco());
    }
}
