package br.com.example.api.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.example.api.models.Pessoa;
import br.com.example.api.services.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

    private Map<UUID, Pessoa> pessoasMap = new HashMap<>();

    public PessoaServiceImpl() {
    }

    public PessoaServiceImpl(Map<UUID, Pessoa> pessoasMap) {
        this.pessoasMap = pessoasMap;
    }

    @Override
    public Pessoa buscarPorCodigo(UUID codigo) {
        if (pessoasMap.containsKey(codigo))
            return pessoasMap.get(codigo);
        return null;
    }

    @Override
    public List<Pessoa> listar() {
        return new ArrayList<>(pessoasMap.values());    
    }

    @Override
    public Pessoa criar(Pessoa pessoa) {
        if(pessoa != null){
            pessoa.setCodigo(UUID.randomUUID());
            pessoasMap.put(pessoa.getCodigo(), pessoa);
        }
        return pessoa;
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        if(pessoasMap.containsKey(pessoa.getCodigo())){
            pessoasMap.put(pessoa.getCodigo(), pessoa);
            return pessoa;
        }
        return null;
    }

    @Override
    public Pessoa excluir(UUID codigo) {
        return pessoasMap.remove(codigo);
    }
}