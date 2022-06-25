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

import com.proyecto.proyecto.dto.NewProductoDTO;
import com.proyecto.proyecto.dto.ProductoDTO;
import com.proyecto.proyecto.servicios.ProductoServicio;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    private final ProductoServicio service;
  
    @Autowired
    public ProductoControlador(ProductoServicio srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<ProductoDTO> create(@Valid @RequestBody NewProductoDTO productoDTO){
        ProductoDTO result = service.create(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> retrive(@PathVariable("id") Long id){
        ProductoDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping() 
    public ResponseEntity<List<ProductoDTO>> list(){
        List<ProductoDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@RequestBody ProductoDTO productoDTO, @PathVariable("id") Long id){
        ProductoDTO result = service.update(productoDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Producto Eliminado");        
    }
}