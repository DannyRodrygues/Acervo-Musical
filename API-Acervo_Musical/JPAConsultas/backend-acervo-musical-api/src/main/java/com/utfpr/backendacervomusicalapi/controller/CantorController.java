package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Cantor;
import com.utfpr.backendacervomusicalapi.service.CantorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cantores")
public class CantorController {

    @Autowired
    CantorService cantorService;

    /*
    GET -> retorna algo(Ready)
    PUT -> edição de dados (Update)
    POST -> criação de algo (Create)
    DELETE -> deletar algo (Delete)
     */

    //GET -> retorna
    @GetMapping
    public ResponseEntity<List<Cantor>> getAll() {
        List<Cantor> cantorList = cantorService.listar();
        if (cantorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cantorList, HttpStatus.OK);
        }
    }

    //http://localhost:8080/cantores/2
    @GetMapping("/{id}")
    public ResponseEntity<Cantor> getOne(@PathVariable(value = "id") Long id) {
        Optional<Cantor> cantorFound = cantorService.encontrar(id);
        return cantorFound.map(cantor -> new ResponseEntity<>(cantor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //PUT -> edita
    @PutMapping("/{id}")
    public ResponseEntity<Cantor> update(@PathVariable(value = "id") Long id,
                                         @RequestBody Cantor cantorUpdated) {
        Optional<Cantor> cantorOld = cantorService.encontrar(id);
        if (cantorOld.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            cantorUpdated.setId(cantorOld.get().getId());
            if (cantorService.salvar(cantorUpdated) != null) {
                return new ResponseEntity<>(cantorUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    // POST -> create
    @PostMapping
    public ResponseEntity<Cantor> create(@RequestBody Cantor cantor) {
        Cantor cantorCreated = cantorService.salvar(cantor);
        if (cantorCreated != null)
            return new ResponseEntity<>(cantorCreated, HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //DELETE -> deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Cantor> delete(@PathVariable(value = "id") Long id) {
        Optional<Cantor> cantorToDelete = cantorService.encontrar(id);
        if (cantorToDelete.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            try {
                cantorService.deletar(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
