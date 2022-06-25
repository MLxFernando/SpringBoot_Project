package com.proyecto.proyecto.servicios.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyecto.dto.CategoriaDTO;
import com.proyecto.proyecto.dto.NewCategoriaDTO;
import com.proyecto.proyecto.excepciones.ResourceNotFoundException;
import com.proyecto.proyecto.modelos.Categoria;
import com.proyecto.proyecto.repositorios.CategoriaRepositorio;
import com.proyecto.proyecto.servicios.CategoriaServicio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    final ModelMapper modelMapper;
    final CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public CategoriaServicioImpl(@Autowired CategoriaRepositorio repository, ModelMapper mapper){
        this.categoriaRepositorio = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public CategoriaDTO create(NewCategoriaDTO categoriaDTO) {
        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);
        categoriaRepositorio.save(categoria);        
        return modelMapper.map(categoria, CategoriaDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaDTO retrieve(Long id) {
        Categoria categoria = categoriaRepositorio.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Categoria no valida"));
        return modelMapper.map(categoria, CategoriaDTO.class);
    }

    @Override
    @Transactional
    public CategoriaDTO update(CategoriaDTO categoriaDTO, Long id) {
        Categoria categoria = categoriaRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));
        
        categoria.setId(id);
        categoria = modelMapper.map(categoriaDTO, Categoria.class);
        categoriaRepositorio.save(categoria);       

        return modelMapper.map(categoria, CategoriaDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Categoria categoria = categoriaRepositorio.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));        
        categoriaRepositorio.deleteById(categoria.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDTO> list() {
        List<Categoria> categorias = categoriaRepositorio.findAll();
        return categorias.stream().map(categoria -> modelMapper.map(categoria, CategoriaDTO.class))
            .collect(Collectors.toList());        
    }
    
}
