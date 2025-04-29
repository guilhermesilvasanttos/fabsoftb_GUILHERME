package br.univille.projfabsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Divergencia;
import br.univille.projfabsoft.service.DivergenciaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.univille.projfabsoft.controller.DivergenciaComtroller;

@RestController
@RequestMapping("/api/v1/divergencias")
public class DivergenciaComtroller {

    @Autowired
    private DivergenciaService service;
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping
    public ResponseEntity<List<Divergencia>> getDivergencias() {
        var listaDivergencias = service.getALL();
        return new ResponseEntity<List<Divergencia>>(listaDivergencias, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Divergencia> postDivergencia(@RequestBody Divergencia divergencia) {
        if(divergencia == null){
            return ResponseEntity.badRequest().build();
        }
        if (divergencia.getId() == 0){
            service.save(divergencia);
            return new ResponseEntity<Divergencia>(divergencia, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Divergencia> putDivergencia(@PathVariable long id,
            @RequestBody Divergencia divergencia) {

        if(id <= 0 || divergencia == null){
            return ResponseEntity.badRequest().build();
        }

        var divergenciaAntiga = service.getById(id);
        if(divergenciaAntiga == null){
            return ResponseEntity.notFound().build();
            
        }

        service.save(divergenciaAntiga);
        return new ResponseEntity<Divergencia>(divergenciaAntiga,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Divergencia> deleteDivergencia(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var divergenciaExcluida = service.getById(id);
        if(divergenciaExcluida == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Divergencia>(divergenciaExcluida, HttpStatus.OK);
    }
}
