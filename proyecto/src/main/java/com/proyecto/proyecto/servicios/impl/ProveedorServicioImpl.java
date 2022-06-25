package com.proyecto.proyecto.servicios.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyecto.dto.NewProveedorDTO;
import com.proyecto.proyecto.dto.ProveedorDTO;
import com.proyecto.proyecto.excepciones.ResourceNotFoundException;
import com.proyecto.proyecto.modelos.Proveedor;
import com.proyecto.proyecto.repositorios.ProveedorRepositorio;
import com.proyecto.proyecto.servicios.ProveedorServicio;

@Service
public class ProveedorServicioImpl implements ProveedorServicio {

    final ModelMapper modelMapper;
    final ProveedorRepositorio proveedorRepositorio;

    @Autowired
    public ProveedorServicioImpl(@Autowired ProveedorRepositorio repository, ModelMapper mapper){
        this.proveedorRepositorio = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ProveedorDTO create(NewProveedorDTO proveedorDTO) {
        Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
        proveedorRepositorio.save(proveedor);        
        return modelMapper.map(proveedor, ProveedorDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public ProveedorDTO retrieve(Long id) {
        Proveedor proveedor = proveedorRepositorio.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Proveedor no valido"));
        return modelMapper.map(proveedor, ProveedorDTO.class);
    }

    @Override
    @Transactional
    public ProveedorDTO update(ProveedorDTO proveedorDTO, Long id) {
        Proveedor proveedor = proveedorRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Proveedor no encontrado"));
        
        proveedor.setId(id);
        proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
        proveedorRepositorio.save(proveedor);       

        return modelMapper.map(proveedor, ProveedorDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Proveedor proveedor = proveedorRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Proveedor no encontrado"));        
        proveedorRepositorio.deleteById(proveedor.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorDTO> list() {
        List<Proveedor> proveedores = proveedorRepositorio.findAll();
        return proveedores.stream().map(proveedor -> modelMapper.map(proveedor, ProveedorDTO.class))
            .collect(Collectors.toList());        
    }
    
}