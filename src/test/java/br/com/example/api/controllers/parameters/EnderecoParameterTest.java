package br.com.example.api.controllers.parameters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnderecoParameterTest {

    @Test
    public void test(){
        var parameter = new EnderecoParameter();
        parameter.setRua("Rua teste");
        parameter.setBairro("Bairro teste");
        parameter.setCep("00000-000");
        parameter.setCidade("cidade teste ");
        parameter.setComplementoCasa("Teste 123");
        parameter.setEstado("SP");
        parameter.setNumeroCasa(564);
        parameter.setPais("Brasil");

        var model = parameter.toModel();

        Assertions.assertEquals(parameter.getRua(), model.getRua());
        Assertions.assertEquals(parameter.getCep(), model.getCep());
        Assertions.assertEquals(parameter.getPais(), model.getPais());
        Assertions.assertEquals(parameter.getEstado(), model.getEstado());
        Assertions.assertEquals(parameter.getCidade(), model.getCidade());
        Assertions.assertEquals(parameter.getBairro(), model.getBairro());
        Assertions.assertEquals(parameter.getNumeroCasa(), model.getNumeroCasa());
        Assertions.assertEquals(parameter.getComplementoCasa(), model.getComplementoCasa());
    }
}
