package br.com.example.api.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.api.controllers.parameters.PessoaParameter;
import br.com.example.api.controllers.presenters.PessoaPresenter;
import br.com.example.api.services.PessoaService;
import io.swagger.annotations.Api;

@Api(tags = "Pessoa")
@RequestMapping("/api/v1/pessoas")
@RestController
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/{codigo_pessoa}")
    public ResponseEntity<PessoaPresenter> buscarPorCodigo(
            @PathVariable("codigo_pessoa") UUID codigo) {

        var pessoa = this.pessoaService.buscarPorCodigo(codigo);

        if (pessoa == null)
            return ResponseEntity.notFound().build();

        var presenter = new PessoaPresenter(pessoa);
        return new ResponseEntity<>(presenter, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<PessoaPresenter>> listar() {
        var retorno = this.pessoaService.listar();

        if (retorno == null || retorno.isEmpty())
            return ResponseEntity.noContent().build();

        var presenter = retorno.stream()
                .map(pessoa -> new PessoaPresenter(pessoa))
                .collect(Collectors.toList());
        return new ResponseEntity<>(presenter, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaPresenter> criar(
            @RequestBody PessoaParameter pessoaParameter) {
        var pessoa = pessoaParameter.toModel();
        pessoa = this.pessoaService.criar(pessoa);

        if (pessoa == null)
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);

        var presenter = new PessoaPresenter(pessoa);
        return new ResponseEntity<>(presenter, HttpStatus.CREATED);
    }

    @PutMapping("/{codigo_pessoa}")
    public ResponseEntity<PessoaPresenter> atualizar(
            @PathVariable("codigo_pessoa") UUID codigo,
            @RequestBody PessoaParameter pessoaParameter) {
        var pessoa = pessoaParameter.toModel();
        pessoa.setCodigo(codigo);
        var retorno = this.pessoaService.atualizar(pessoa);

        if (retorno == null)
            return ResponseEntity.notFound().build();

        var presenter = new PessoaPresenter(retorno);
        return new ResponseEntity<>(presenter, HttpStatus.OK);
    }

    @DeleteMapping("/{codigo_pessoa}")
    public ResponseEntity<PessoaPresenter> excluir(
            @PathVariable("codigo_pessoa") UUID codigo) {
        var retorno = this.pessoaService.excluir(codigo);

        if (retorno == null)
            return ResponseEntity.notFound().build();

        var presenter = new PessoaPresenter(retorno);
        return new ResponseEntity<>(presenter, HttpStatus.OK);
    }
}