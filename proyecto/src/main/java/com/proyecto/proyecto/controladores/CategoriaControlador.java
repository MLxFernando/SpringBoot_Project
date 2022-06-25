package com.proyecto.proyecto.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.CategoriaDTO;
import com.proyecto.proyecto.dto.NewCategoriaDTO;
import com.proyecto.proyecto.servicios.CategoriaServicio;

@RestController
@RequestMapping("/categorias")
public class CategoriaControlador {
    private final CategoriaServicio service;
  
    @Autowired
    public CategoriaControlador(CategoriaServicio srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<CategoriaDTO> create(@Valid @RequestBody NewCategoriaDTO categoriaDTO){
        CategoriaDTO result = service.create(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> retrive(@PathVariable("id") Long id){
        CategoriaDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaDTO>> list(){
        List<CategoriaDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoriaDTO, @PathVariable("id") Long id){
        CategoriaDTO result = service.update(categoriaDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Categoria Eliminada");        
    }
}
