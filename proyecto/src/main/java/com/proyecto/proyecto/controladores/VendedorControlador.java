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

import com.proyecto.proyecto.dto.NewVendedorDTO;
import com.proyecto.proyecto.dto.VendedorDTO;
import com.proyecto.proyecto.servicios.VendedorServicio;

@RestController
@RequestMapping("/vendedores")
public class VendedorControlador {
    private final VendedorServicio service;
  
    @Autowired
    public VendedorControlador(VendedorServicio srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<VendedorDTO> create(@Valid @RequestBody NewVendedorDTO vendedorDTO){
        VendedorDTO result = service.create(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> retrive(@PathVariable("id") Long id){
        VendedorDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping()
    public ResponseEntity<List<VendedorDTO>> list(){
        List<VendedorDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendedorDTO> update(@RequestBody VendedorDTO vendedorDTO, @PathVariable("id") Long id){
        VendedorDTO result = service.update(vendedorDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Vendedor Eliminado");        
    }
}