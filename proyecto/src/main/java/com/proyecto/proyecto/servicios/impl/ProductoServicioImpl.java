package com.proyecto.proyecto.servicios.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyecto.dto.NewProductoDTO;
import com.proyecto.proyecto.dto.ProductoDTO;
import com.proyecto.proyecto.excepciones.ResourceNotFoundException;
import com.proyecto.proyecto.modelos.Producto;
import com.proyecto.proyecto.repositorios.ProductoRepositorio;
import com.proyecto.proyecto.servicios.ProductoServicio;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    final ModelMapper modelMapper;
    final ProductoRepositorio productoRepositorio;

    @Autowired
    public ProductoServicioImpl(@Autowired ProductoRepositorio repository, ModelMapper mapper){
        this.productoRepositorio = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public ProductoDTO create(NewProductoDTO productoDTO) {
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        productoRepositorio.save(producto);        
        return modelMapper.map(producto, ProductoDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO retrieve(Long id) {
        Producto producto = productoRepositorio.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Producto no valido"));
        return modelMapper.map(producto, ProductoDTO.class);
    }

    @Override
    @Transactional
    public ProductoDTO update(ProductoDTO productoDTO, Long id) {
        Producto producto = productoRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Producto no encontrado"));
        
        producto.setId(id);
        producto = modelMapper.map(productoDTO, Producto.class);
        productoRepositorio.save(producto);       

        return modelMapper.map(producto, ProductoDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Producto producto = productoRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Producto no encontrado"));        
        productoRepositorio.deleteById(producto.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> list() {
        List<Producto> productos = productoRepositorio.findAll();
        return productos.stream().map(producto -> modelMapper.map(producto, ProductoDTO.class))
            .collect(Collectors.toList());        
    }
    
}
