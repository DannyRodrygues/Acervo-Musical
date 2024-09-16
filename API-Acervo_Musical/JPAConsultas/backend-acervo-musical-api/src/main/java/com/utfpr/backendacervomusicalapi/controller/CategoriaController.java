package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Categoria;
import com.utfpr.backendacervomusicalapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll(){
        List<Categoria> categoriaList = categoriaService.listar();
        if(categoriaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(categoriaList, HttpStatus.OK);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Categoria> getOne(@PathVariable(value ="id") Long id){
        Optional <Categoria> categoriaFound = categoriaService.encontrar(id);
        return categoriaFound.map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //PUT -> edita
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable(value = "id") Long id,
                                            @RequestBody Categoria categoriaUpdated){
        Optional<Categoria> categoriaOld = categoriaService.encontrar(id);
        if (categoriaOld.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            categoriaUpdated.setId(categoriaOld.get().getId());
            if (categoriaService.salvar(categoriaUpdated) != null)
                return new ResponseEntity<>(categoriaUpdated, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //POST -> create
    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        Categoria categoriaCreated = categoriaService.salvar(categoria);
        if(categoriaCreated != null)
            return new ResponseEntity<>(categoriaCreated, HttpStatus.CREATED);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //DELETE -> deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable(value = "id")Long id){
        Optional<Categoria> categoriaToDelete = categoriaService.encontrar(id);
        if (categoriaToDelete.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            try{
                categoriaService.deletar(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
  }



