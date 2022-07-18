package com.proyecto.proyecto.controladores;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.NewProveedorDTO;
import com.proyecto.proyecto.dto.ProveedorCategoriaDTO;
import com.proyecto.proyecto.dto.ProveedorDTO;
import com.proyecto.proyecto.servicios.ProveedorServicio;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categorias")
public class ProveedorControlador {
    
    final ProveedorServicio service;

    public ProveedorControlador (ProveedorServicio srv){
        this.service = srv;
    }

    /* ================ CREATE ================ */
    @PostMapping("/{id}/proveedores")
    public ResponseEntity<ProveedorDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NewProveedorDTO proveedorDTO){
        ProveedorDTO proveedorDTOs = service.create(id, proveedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedorDTOs);        
    }

    /* ================ RETRIEVE ================ */
    @GetMapping("/{idCategoria}/proveedores/{id}")
    public ResponseEntity<ProveedorCategoriaDTO> retrive(@PathVariable("idCategoria") Long idCategoria, @PathVariable("id") Long id){
        ProveedorCategoriaDTO result = service.retrieve(idCategoria, id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{idCategoria}/proveedores/{id}")
    public ResponseEntity<ProveedorCategoriaDTO> update(@RequestBody ProveedorDTO proveedorDTO, @PathVariable("idCategoria") Long idCategoria, @PathVariable("id") Long id){
        ProveedorCategoriaDTO result = service.update(proveedorDTO, idCategoria, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{idCategoria}/proveedores/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idCategoria") Long idCategoria, @PathVariable("id") Long id){
        service.delete(idCategoria, id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @GetMapping("/{id}/proveedores")
    public ResponseEntity<List<ProveedorDTO>> list(@PathVariable("id") Long id){
        List<ProveedorDTO> proveedores = service.list(id);
        return ResponseEntity.ok().body(proveedores);        
    }

}
