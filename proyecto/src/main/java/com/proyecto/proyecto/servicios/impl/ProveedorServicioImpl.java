package com.proyecto.proyecto.servicios.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyecto.dto.NewProveedorDTO;
import com.proyecto.proyecto.dto.ProveedorCategoriaDTO;
import com.proyecto.proyecto.dto.ProveedorDTO;
import com.proyecto.proyecto.excepciones.NoContentException;
import com.proyecto.proyecto.excepciones.ResourceNotFoundException;
import com.proyecto.proyecto.modelos.Categoria;
import com.proyecto.proyecto.modelos.Proveedor;
import com.proyecto.proyecto.repositorios.CategoriaRepositorio;
import com.proyecto.proyecto.repositorios.ProveedorRepositorio;
import com.proyecto.proyecto.servicios.ProveedorServicio;

@Service
public class ProveedorServicioImpl implements ProveedorServicio {

    final ModelMapper modelMapper;
    final ProveedorRepositorio repositorio;
    final CategoriaRepositorio categoriaRepositorio;

    public ProveedorServicioImpl(ProveedorRepositorio r, CategoriaRepositorio e, ModelMapper m){
        
        this.repositorio=r;
        this.categoriaRepositorio=e;
        this.modelMapper = m;
    }

    @Override
    @Transactional
    public ProveedorDTO create(Long idCategoria, NewProveedorDTO proveedorDTO) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria)
            .orElseThrow(()-> new ResourceNotFoundException("Categoria no Valida"));
        Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);    
        proveedor.setCategoria(categoria);
        repositorio.save(proveedor);
        return modelMapper.map(proveedor, ProveedorDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public ProveedorCategoriaDTO retrieve(Long idCategoria, Long id) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria)
            .orElseThrow(()-> new ResourceNotFoundException("Proveedor no valido"));
        Proveedor proveedor = repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Proveedor no encontrado"));
        proveedor.setCategoria(categoria);
        return modelMapper.map(proveedor, ProveedorCategoriaDTO.class);
    }

    @Override
    @Transactional
    public ProveedorCategoriaDTO update(ProveedorDTO proveedorDTO, Long idCategoria,Long id) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria)
        .orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));
        Proveedor proveedor = repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Proveedor no valido"));
        proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
        proveedor.setCategoria(categoria);
        repositorio.save(proveedor);       
        return modelMapper.map(proveedor, ProveedorCategoriaDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long idCategoria,Long id) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria)
        .orElseThrow(()-> new ResourceNotFoundException("Categoria no valida"));
        Proveedor proveedor = repositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria no valida"));
        proveedor.setCategoria(categoria);
        repositorio.deleteById(proveedor.getId());  
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProveedorDTO> list(Long idCategoria) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria)
            .orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));
        List<Proveedor> proveedores = repositorio.findByCategoria(categoria);
        if(proveedores.isEmpty()) throw new NoContentException("Categoria Vacia");
        
        return proveedores.stream().map(p -> modelMapper.map(p, ProveedorDTO.class) )
            .collect(Collectors.toList());
    }

} 