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

import com.proyecto.proyecto.dto.NewProveedorDTO;
import com.proyecto.proyecto.dto.ProveedorDTO;
import com.proyecto.proyecto.servicios.ProveedorServicio;

@RestController
@RequestMapping("/proveedores")
public class ProveedorControlador {
    private final ProveedorServicio service;
  
    @Autowired
    public ProveedorControlador(ProveedorServicio srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<ProveedorDTO> create(@Valid @RequestBody NewProveedorDTO proveedorDTO){
        ProveedorDTO result = service.create(proveedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> retrive(@PathVariable("id") Long id){
        ProveedorDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() 
    public ResponseEntity<List<ProveedorDTO>> list(){
        List<ProveedorDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> update(@RequestBody ProveedorDTO proveedorDTO, @PathVariable("id") Long id){
        ProveedorDTO result = service.update(proveedorDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Proveedor Eliminado");        
    }
}