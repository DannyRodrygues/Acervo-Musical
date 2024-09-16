package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Fone;
import com.utfpr.backendacervomusicalapi.entity.Gravacao;
import com.utfpr.backendacervomusicalapi.service.GravacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gravacoes")
public class GravacaoController {

    @Autowired
    GravacaoService gravacaoService;

    @GetMapping
    public ResponseEntity<List<Gravacao>> getAll(){
        List<Gravacao> gravacaoList = gravacaoService.listar();
        if (gravacaoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            return new ResponseEntity<>(gravacaoList, HttpStatus.OK);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Gravacao> getOne(@PathVariable(value = "id")Long id){
        Optional <Gravacao> gravacaoFound = gravacaoService.encontrar(id);
        return gravacaoFound.map(gravacao -> new ResponseEntity<>(gravacao, HttpStatus.OK ))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Gravacao> update(@PathVariable(value = "id") Long id,
                                       @RequestBody Gravacao gravacaoUpdated){
        Optional<Gravacao> gravacaoOld = gravacaoService.encontrar(id);
        if (gravacaoOld.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            gravacaoUpdated.setId(gravacaoOld.get().getId());
            if (gravacaoService.salvar(gravacaoUpdated) != null)
                return new ResponseEntity<>(gravacaoUpdated, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //POST -> create
    @PostMapping
    public ResponseEntity<Gravacao> create(@RequestBody Gravacao gravacao){
        Gravacao gravacaoCreated = gravacaoService.salvar(gravacao);
        if(gravacaoCreated != null)
            return new ResponseEntity<>(gravacaoCreated, HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //DELETE -> deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Gravacao> delete(@PathVariable(value = "id")Long id){
        Optional<Gravacao> gravacaoToDelete = gravacaoService.encontrar(id);
        if (gravacaoToDelete.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try{
                gravacaoService.deletar(id);
                return  new ResponseEntity<>(HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
