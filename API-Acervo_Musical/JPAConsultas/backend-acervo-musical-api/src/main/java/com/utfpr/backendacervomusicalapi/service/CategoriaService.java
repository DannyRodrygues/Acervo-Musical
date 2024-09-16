package com.utfpr.backendacervomusicalapi.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.utfpr.backendacervomusicalapi.entity.Categoria;
import com.utfpr.backendacervomusicalapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listar(){
        return repository.findAll();
    }

    public Optional<Categoria> encontrar(Long id){
        return repository.findById(id);
    }

    public Categoria salvar(Categoria categoria){
        try{
            return repository.save(categoria);
        }catch (Exception e){
            return null;
        }
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
