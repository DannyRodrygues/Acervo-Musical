package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Gravacao;
import com.utfpr.backendacervomusicalapi.entity.Gravadora;
import com.utfpr.backendacervomusicalapi.repository.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GravadoraService {

    @Autowired
    private GravadoraRepository repository;

    public List<Gravadora> listar(){
        return repository.findAll();
    }
    public Optional<Gravadora> encontrar (Long id){
        return repository.findById(id);
    }

    public Gravadora salvar(Gravadora gravadora){
        try {
            return repository.save(gravadora);
        }catch (Exception e){
            return null;
        }
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
