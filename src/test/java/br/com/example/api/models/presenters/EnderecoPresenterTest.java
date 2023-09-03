package br.com.example.api.models.presenters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.example.api.models.Endereco;

public class EnderecoPresenterTest {

    @Test
    public void test(){
        var model = new Endereco();
        model.setRua("Rua teste");
        model.setBairro("Bairro teste");
        model.setCep("00000-000");
        model.setCidade("cidade teste ");
        model.setComplementoCasa("Teste 123");
        model.setEstado("SP");
        model.setNumeroCasa(564);
        model.setPais("Brasil");

        var presenter = new EnderecoPresenter(model);

        Assertions.assertEquals(model.getNumeroCasa(), presenter.getNumeroCasa());
        Assertions.assertEquals(model.getBairro(), presenter.getBairro());
        Assertions.assertEquals(model.getCep(), presenter.getCep());
        Assertions.assertEquals(model.getCidade(), presenter.getCidade());
        Assertions.assertEquals(model.getComplementoCasa(), presenter.getComplementoCasa());
        Assertions.assertEquals(model.getEstado(), presenter.getEstado());
        Assertions.assertEquals(model.getPais(), presenter.getPais());
        Assertions.assertEquals(model.getRua(), presenter.getRua());
    }

}
