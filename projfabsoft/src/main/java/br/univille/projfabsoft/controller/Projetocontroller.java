package br.univille.projfabsoft.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Projeto;
import br.univille.projfabsoft.service.ProjetoService;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/projeto")
public class Projetocontroller{

    @Autowired
    private ProjetoService service;
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> getProjeto() {
        var listaProjeto = service.getAll();
        return new ResponseEntity<List<Projeto>>(listaProjeto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Projeto> postProjeto(@RequestBody Projeto projeto) {
        if(projeto == null){
            return ResponseEntity.badRequest().build();
        }
        if (projeto.getId() == 0){
            service.save(projeto);
            return new ResponseEntity<Projeto>(projeto, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> putProjeto(@PathVariable long id,
            @RequestBody Projeto projeto) {

        if(id <= 0 || projeto == null){
            return ResponseEntity.badRequest().build();
        }

        Projeto projetoAntigo = service.getById(id);
        if(projetoAntigo == null){
            return ResponseEntity.notFound().build();
        }
        projetoAntigo.setNome(projeto.getNome());
        projetoAntigo.setStatus(projeto.getStatus());    
        service.save(projetoAntigo);
        return new ResponseEntity<Projeto>(projetoAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Projeto> deleteProjeto(@PathVariable long id) {
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var projetoExcluido = service.getById(id);
        if(projetoExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Projeto>((Projeto) projetoExcluido, HttpStatus.OK);
    }
}
