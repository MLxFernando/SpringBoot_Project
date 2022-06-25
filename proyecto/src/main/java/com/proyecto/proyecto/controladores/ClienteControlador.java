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

import com.proyecto.proyecto.dto.ClienteDTO;
import com.proyecto.proyecto.dto.NewClienteDTO;
import com.proyecto.proyecto.servicios.ClienteServicio;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
    private final ClienteServicio service;
  
    @Autowired
    public ClienteControlador(ClienteServicio srv){
        this.service =srv;
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody NewClienteDTO clienteDTO){
        ClienteDTO result = service.create(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> retrive(@PathVariable("id") Long id){
        ClienteDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> list(){
        List<ClienteDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO, @PathVariable("id") Long id){
        ClienteDTO result = service.update(clienteDTO, id);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Cliente Eliminado");        
    }
}
