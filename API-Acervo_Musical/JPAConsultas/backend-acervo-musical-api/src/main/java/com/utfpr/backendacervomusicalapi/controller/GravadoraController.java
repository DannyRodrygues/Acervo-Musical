package com.utfpr.backendacervomusicalapi.controller;


import com.utfpr.backendacervomusicalapi.entity.Fone;
import com.utfpr.backendacervomusicalapi.entity.Gravacao;
import com.utfpr.backendacervomusicalapi.entity.Gravadora;
import com.utfpr.backendacervomusicalapi.service.GravadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gravadoras")
public class GravadoraController {

    @Autowired
    GravadoraService gravadoraService;

    @GetMapping
    public ResponseEntity<List<Gravadora>> getAll(){
        List<Gravadora> gravadoraList = gravadoraService.listar();
        if (gravadoraList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(gravadoraList, HttpStatus.OK);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Gravadora> getOne(@PathVariable(value = "id")Long id){
        Optional<Gravadora> gravadoraFound = gravadoraService.encontrar(id);
        return gravadoraFound.map(gravadora -> new ResponseEntity<>(gravadora, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Gravadora> update(@PathVariable(value = "id") Long id,
                                       @RequestBody Gravadora gravadoraUpdated){
        Optional<Gravadora> gravadoraOld = gravadoraService.encontrar(id);
        if (gravadoraOld.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            gravadoraUpdated.setId(gravadoraOld.get().getId());
            if (gravadoraService.salvar(gravadoraUpdated) != null)
                return new ResponseEntity<>(gravadoraUpdated, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //POST -> create
    @PostMapping
    public ResponseEntity<Gravadora> create(@RequestBody Gravadora gravadora){
        Gravadora gravadoraCreated = gravadoraService.salvar(gravadora);
        if(gravadoraCreated != null)
            return new ResponseEntity<>(gravadoraCreated, HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //DELETE -> deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Gravadora> delete(@PathVariable(value = "id") Long id){
        Optional<Gravadora> gravadoraToDelete = gravadoraService.encontrar(id);
        if (gravadoraToDelete.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try{
                gravadoraService.deletar(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
