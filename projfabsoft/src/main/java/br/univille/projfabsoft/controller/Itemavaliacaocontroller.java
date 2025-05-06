package br.univille.projfabsoft.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.ItemAvaliacao;
import br.univille.projfabsoft.service.ItemavaliacaoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/item")
public class Itemavaliacaocontroller{

    @Autowired
    private ItemavaliacaoService service;
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping
    public ResponseEntity<List<ItemAvaliacao>> getItemAvaliacao() {
        var listaItemAvaliacao = service.getAll();
        return new ResponseEntity<List<ItemAvaliacao>>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemAvaliacao> postItemAvaliacao(@RequestBody ItemAvaliacao itemAvaliacao) {
        if(itemAvaliacao == null){
            return ResponseEntity.badRequest().build();
        }
        if (itemAvaliacao.getId() == 0){
            service.save(itemAvaliacao);
            return new ResponseEntity<ItemAvaliacao>(itemAvaliacao, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemAvaliacao> putItemAvaliacao(@PathVariable long id,
            @RequestBody ItemAvaliacao itemAvaliacao) {

        if(id <= 0 || itemAvaliacao == null){
            return ResponseEntity.badRequest().build();
        }

        ItemAvaliacao itemAvaliacaoAntigo = service.getById(id);
        if(itemAvaliacaoAntigo == null){
            return ResponseEntity.notFound().build();
        }
        itemAvaliacaoAntigo.setStatus(itemAvaliacao.getStatus());
        itemAvaliacaoAntigo.setDescricao(itemAvaliacao.getDescricao());    
        service.save(itemAvaliacaoAntigo);
        return new ResponseEntity<ItemAvaliacao>(itemAvaliacaoAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItemAvaliacao> deleteItemAvaliacao(@PathVariable long id) {
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var itemAvaliacaoExcluido = service.getById(id);
        if(itemAvaliacaoExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<ItemAvaliacao>((ItemAvaliacao) itemAvaliacaoExcluido, HttpStatus.OK);
    }
}
