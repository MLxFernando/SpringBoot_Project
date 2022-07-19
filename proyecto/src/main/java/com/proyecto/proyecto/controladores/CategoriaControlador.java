package com.proyecto.proyecto.controladores;

import java.util.List;

import javax.validation.Valid;

import com.proyecto.proyecto.dto.CategoriaDTO;
import com.proyecto.proyecto.dto.CategoriaListaDTO;
import com.proyecto.proyecto.dto.NewCategoriaDTO;
import com.proyecto.proyecto.servicios.CategoriaServicio;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categorias")

public class CategoriaControlador {
    private final CategoriaServicio service;
  
    public CategoriaControlador (CategoriaServicio srv){
        this.service =srv;
    }
    
    /* ================ CREATE ================ */
    @PostMapping()
    public ResponseEntity<CategoriaDTO> create(@Valid @RequestBody NewCategoriaDTO categoriaDTO){
        CategoriaDTO result = service.create(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    /* ================ RETRIEVE ================ */
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> retrive(@PathVariable("id") Long id){
        CategoriaDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoriaDTO, @PathVariable("id") Long id){
        CategoriaDTO result = service.update(categoriaDTO, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<CategoriaListaDTO>> list(@PathVariable("page") int page, 
        @PathVariable("size") int size,
        @RequestParam(name = "sort", required = false) String sort){
        List<CategoriaListaDTO> result  = service.list(page, size, sort);
        return ResponseEntity.ok().body(result);        
    }

     /* ================ COUNT ================ */
     @GetMapping("/count")
     public ResponseEntity<Long> count(){
         long result = service.count();
         return ResponseEntity.ok().body(result);        
     }

}