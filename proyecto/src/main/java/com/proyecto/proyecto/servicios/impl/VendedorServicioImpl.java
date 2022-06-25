package com.proyecto.proyecto.servicios.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyecto.dto.NewVendedorDTO;
import com.proyecto.proyecto.dto.VendedorDTO;
import com.proyecto.proyecto.excepciones.ResourceNotFoundException;
import com.proyecto.proyecto.modelos.Vendedor;
import com.proyecto.proyecto.repositorios.VendedorRepositorio;
import com.proyecto.proyecto.servicios.VendedorServicio;

@Service
public class VendedorServicioImpl implements VendedorServicio {

    final ModelMapper modelMapper;
    final VendedorRepositorio vendedorRepositorio;

    @Autowired
    public VendedorServicioImpl(@Autowired VendedorRepositorio repository, ModelMapper mapper){
        this.vendedorRepositorio = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public VendedorDTO create(NewVendedorDTO vendedorDTO) {
        Vendedor vendedor = modelMapper.map(vendedorDTO, Vendedor.class);
        vendedorRepositorio.save(vendedor);        
        return modelMapper.map(vendedor, VendedorDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public VendedorDTO retrieve(Long id) {
        Vendedor vendedor = vendedorRepositorio.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Vendedor no valido"));
        return modelMapper.map(vendedor, VendedorDTO.class);
    }

    @Override
    @Transactional
    public VendedorDTO update(VendedorDTO vendedorDTO, Long id) {
        Vendedor vendedor = vendedorRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vendedor no encontrado"));
        
        vendedor.setId(id);
        vendedor = modelMapper.map(vendedorDTO, Vendedor.class);
        vendedorRepositorio.save(vendedor);       

        return modelMapper.map(vendedor, VendedorDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Vendedor vendedor = vendedorRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vendedor no encontrado"));        
        vendedorRepositorio.deleteById(vendedor.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<VendedorDTO> list() {
        List<Vendedor> vendedores = vendedorRepositorio.findAll();
        return vendedores.stream().map(vendedor -> modelMapper.map(vendedor, VendedorDTO.class))
            .collect(Collectors.toList());        
    }
    
}
