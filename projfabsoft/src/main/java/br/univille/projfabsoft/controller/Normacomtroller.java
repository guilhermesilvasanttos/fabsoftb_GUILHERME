package br.univille.projfabsoft.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Norma;
import br.univille.projfabsoft.service.Norma;
import br.univille.projfabsoft.service.NormaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/itemavaliacoes")
public class Normacomtroller{

    @Autowired
    private NormaService service;
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping
    public ResponseEntity<List<Norma>> getNorma() {
        var listaNorma = service.getAll();
        return new ResponseEntity<List<Norma>>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Norma> postNorma(@RequestBody Norma norma) {
        if(norma == null){
            return ResponseEntity.badRequest().build();
        }
        if (Norma.getId() == 0){
            service.save(norma);
            return new ResponseEntity<Norma>(norma, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Norma> putNorma(@PathVariable long id,
            @RequestBody Norma norma) {

        if(id <= 0 || norma == null){
            return ResponseEntity.badRequest().build();
        }

        Norma normaAntigo = service.getById(id);
        if(normaAntigo == null){
            return ResponseEntity.notFound().build();
        }
        normaAntigo.setStatus(norma.getStatus());
        normaAntigo.setDescricao(norma.getDescricao());    
        service.save(normaAntigo);
        return new ResponseEntity<Norma>(normaAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Norma> deleteNorma(@PathVariable long id) {
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var normaExcluido = service.getById(id);
        if(normaExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Norma>((Norma) normaExcluido, HttpStatus.OK);
    }
}
