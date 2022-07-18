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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.NewProductoDTO;
import com.proyecto.proyecto.dto.ProductoDTO;
import com.proyecto.proyecto.servicios.ProductoServicio;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categorias")
public class ProductoControlador {
    
    final ProductoServicio service;

    public ProductoControlador (ProductoServicio srv){
        this.service = srv;
    }

    /* ================ CREATE ================ */
    @PostMapping("/{id}/proveedores/{idProveedor}/productos")
    public ResponseEntity<List<ProductoDTO>> create(@PathVariable("id") Long id, @PathVariable("idProveedor") Long idProveedor, @Valid @RequestBody List<NewProductoDTO> productosDTO){
        List<ProductoDTO> productoDTO = service.create(id, idProveedor, productosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);        
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{id}/proveedores/{idProveedor}/productos")
    public ResponseEntity<List<ProductoDTO>> delete(@PathVariable("id") Long id, @PathVariable("idProveedor") Long idProveedor){
        service.remove(id, idProveedor);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @GetMapping("/{id}/proveedores/{idProveedor}/productos")
    public ResponseEntity<List<ProductoDTO>> list(@PathVariable("id") Long id, @PathVariable("idProveedor") Long idProveedor){
        List<ProductoDTO> productoDTO = service.list(id, idProveedor);
        return ResponseEntity.status(HttpStatus.OK).body(productoDTO);        
    }

}
