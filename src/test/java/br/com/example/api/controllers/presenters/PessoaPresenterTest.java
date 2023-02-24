package br.com.example.api.controllers.presenters;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.example.api.models.Pessoa;

public class PessoaPresenterTest {

    @Test
    public void test(){
        var model = new Pessoa();
        model.setCodigo(UUID.randomUUID());
        model.setDataNascimento(LocalDate.of(1990, 6,12));
        model.setDocumento("01234567890");
        model.setNome("Pessoa_1");
        model.setTipoDocumento("RG");

        var presenter = new PessoaPresenter(model);
        
        Assertions.assertEquals(model.getNome(), presenter.getNome());
        Assertions.assertEquals(model.getCodigo(), presenter.getCodigo());
        Assertions.assertEquals(model.getEndereco(), presenter.getEndereco());
        Assertions.assertEquals(model.getDocumento(), presenter.getDocumento());
        Assertions.assertEquals(model.getTipoDocumento(), presenter.getTipoDocumento());
        Assertions.assertEquals(model.getDataNascimento(), presenter.getDataNascimento());
    }
}
