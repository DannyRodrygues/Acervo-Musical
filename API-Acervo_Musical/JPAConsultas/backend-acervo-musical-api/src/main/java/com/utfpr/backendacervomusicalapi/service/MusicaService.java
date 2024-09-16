package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Gravacao;
import com.utfpr.backendacervomusicalapi.entity.Musica;
import com.utfpr.backendacervomusicalapi.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository repository;
    
    public List<Musica> listar() {

        return repository.findAll();
   }
    public Optional<Musica> encontrar(Long id){
        return repository.findById(id);
    }

    public Musica salvar(Musica musica){
        try {
            return repository.save(musica);
        }catch (Exception e){
            return null;
        }
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
