package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Fone;
import com.utfpr.backendacervomusicalapi.repository.FoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoneService {

    @Autowired
    private FoneRepository repository;

    public List<Fone> listar(){
        return repository.findAll();
    }

    public Optional<Fone> encontrar(Long id){
        return repository.findById(id);
    }

    public Fone salvar(Fone fone){
        try {
            return repository.save(fone);
        }catch (Exception e){
            return null;
        }
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
