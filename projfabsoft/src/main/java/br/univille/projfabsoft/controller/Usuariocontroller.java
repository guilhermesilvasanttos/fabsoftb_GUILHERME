package br.univille.projfabsoft.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft.entity.Usuario;
import br.univille.projfabsoft.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/usuario")
public class Usuariocontroller{

    @Autowired
    private UsuarioService service;
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        var listaUsuario = service.getAll();
        return new ResponseEntity<List<Usuario>>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
        if(usuario == null){
            return ResponseEntity.badRequest().build();
        }
        if (usuario.getId() == 0){
            service.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> putUsuario(@PathVariable long id,
            @RequestBody Usuario usuario) {

        if(id <= 0 || usuario == null){
            return ResponseEntity.badRequest().build();
        }

        Usuario usuarioAntigo = service.getById(id);
        if(usuarioAntigo == null){
            return ResponseEntity.notFound().build();
        }
        usuarioAntigo.setEmail(usuario.getEmail());
        usuarioAntigo.setNome(usuario.getNome());    
        service.save(usuarioAntigo);
        return new ResponseEntity<Usuario>(usuarioAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable long id) {
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        var usuarioExcluido = service.getById(id);
        if(usuarioExcluido == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);

        return new ResponseEntity<Usuario>((Usuario) usuarioExcluido, HttpStatus.OK);
    }
}
