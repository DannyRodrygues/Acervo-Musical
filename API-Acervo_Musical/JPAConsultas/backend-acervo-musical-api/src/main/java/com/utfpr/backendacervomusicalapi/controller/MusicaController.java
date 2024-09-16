package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Fone;
import com.utfpr.backendacervomusicalapi.entity.Musica;
import com.utfpr.backendacervomusicalapi.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    MusicaService musicaService;

    @GetMapping
    public ResponseEntity<List<Musica>> getAll(){
        List <Musica> musicaList = musicaService.listar();
        if(musicaList.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }else {
            return new ResponseEntity<>(musicaList, HttpStatus.OK);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Musica> getOne(@PathVariable(value = "id")Long id){
        Optional<Musica> musicaFound = musicaService.encontrar(id);
        return musicaFound.map(musica -> new ResponseEntity<>(musica, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Musica> update(@PathVariable(value = "id") Long id,
                                       @RequestBody Musica musicaUpdated){
        Optional<Musica> musicaOld = musicaService.encontrar(id);
        if (musicaOld.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            musicaUpdated.setId(musicaOld.get().getId());
            if (musicaService.salvar(musicaUpdated) != null)
                return new ResponseEntity<>(musicaUpdated, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //POST -> create
    @PostMapping
    public ResponseEntity<Musica> create(@RequestBody Musica musica){
        Musica musicaCreated = musicaService.salvar(musica);
        if(musicaCreated != null)
            return new ResponseEntity<>(musicaCreated, HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //DELETE -> deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Musica> delete(@PathVariable(value = "id")Long id){
        Optional<Musica> musicaToDelete = musicaService.encontrar(id);
        if (musicaToDelete.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try{
                musicaService.deletar(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}