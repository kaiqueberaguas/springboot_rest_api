package br.com.example.api.services;

import java.util.List;
import java.util.UUID;

import br.com.example.api.models.Pessoa;

public interface PessoaService {
    
    Pessoa buscarPorCodigo(UUID codigo);

    List<Pessoa> listar();

    Pessoa criar(Pessoa pessoa);
    
    Pessoa atualizar(Pessoa pessoa);

    Pessoa excluir(UUID codigo);
    
}