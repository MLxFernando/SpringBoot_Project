package com.proyecto.proyecto.servicios.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyecto.dto.ClienteDTO;
import com.proyecto.proyecto.dto.NewClienteDTO;
import com.proyecto.proyecto.excepciones.ResourceNotFoundException;
import com.proyecto.proyecto.modelos.Cliente;
import com.proyecto.proyecto.repositorios.ClienteRepositorio;
import com.proyecto.proyecto.servicios.ClienteServicio;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    final ModelMapper modelMapper;
    final ClienteRepositorio clienteRepositorio;

    @Autowired
    public ClienteServicioImpl(@Autowired ClienteRepositorio repository, ModelMapper mapper){
        this.clienteRepositorio = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ClienteDTO create(NewClienteDTO clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepositorio.save(cliente);        
        return modelMapper.map(cliente, ClienteDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO retrieve(Long id) {
        Cliente cliente = clienteRepositorio.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Cliente no valido"));
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    @Transactional
    public ClienteDTO update(ClienteDTO clienteDTO, Long id) {
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente no encontrado"));
        
        cliente.setId(id);
        cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepositorio.save(cliente);       

        return modelMapper.map(cliente, ClienteDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente no encontrado"));        
        clienteRepositorio.deleteById(cliente.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> list() {
        List<Cliente> clientes = clienteRepositorio.findAll();
        return clientes.stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
            .collect(Collectors.toList());        
    }
    
}
