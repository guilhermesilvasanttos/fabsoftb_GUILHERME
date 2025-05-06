package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Documento;
import br.univille.projfabsoft.service.DocumentoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/documentos")
public class Documentocontroller {

    @Autowired
    private DocumentoService service;

    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping
    public ResponseEntity<List<Documento>> getDocumentos() {
        var listaDocumentos = service.getAll();
        return new ResponseEntity<List<Documento>>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Documento> postDocumento(@RequestBody Documento documento) {
        if(documento == null){
            return ResponseEntity.badRequest().build();
        }
        if (documento.getId() == 0){
            service.save(documento);
            return new ResponseEntity<Documento>(documento, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documento> putDocumento(@PathVariable long id,
            @RequestBody Documento documento) {

        if(id <= 0 || documento == null){
            return ResponseEntity.badRequest().build();
        }

        var documentoAntigo = service.getById(id);
        if(documentoAntigo == null){
            return ResponseEntity.notFound().build();   
        }
        documentoAntigo.setTitulo(documentoAntigo.getTitulo());
        documentoAntigo.setConteudo(documentoAntigo.getConteudo());
        service.save(documentoAntigo);

        return new ResponseEntity<Documento>(documentoAntigo,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Documento> deleteDocumento(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var documentoExcluido = service.getById(id);
        if(documentoExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Documento>(documentoExcluido, HttpStatus.OK);
    }
}

