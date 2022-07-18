package com.proyecto.proyecto.servicios.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyecto.dto.CategoriaDTO;
import com.proyecto.proyecto.dto.CategoriaListaDTO;
import com.proyecto.proyecto.dto.NewCategoriaDTO;
import com.proyecto.proyecto.excepciones.NoContentException;
import com.proyecto.proyecto.excepciones.ResourceNotFoundException;
import com.proyecto.proyecto.modelos.Categoria;
import com.proyecto.proyecto.repositorios.CategoriaRepositorio;
import com.proyecto.proyecto.servicios.CategoriaServicio;

@Service
public class CategoriaServicioImpl implements CategoriaServicio {

    final ModelMapper modelMapper;
    final CategoriaRepositorio categoriaRepositorio;

    public CategoriaServicioImpl(CategoriaRepositorio repository, ModelMapper mapper){
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
        

       Categoria categoriaUpdated = modelMapper.map(categoriaDTO, Categoria.class);
        categoriaUpdated.setCreatedBy(categoria.getCreatedBy());
        categoriaUpdated.setCreatedDate(categoria.getCreatedDate());
        categoriaRepositorio.save(categoriaUpdated);   
        return modelMapper.map(categoriaUpdated, CategoriaDTO.class);
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
    public List<CategoriaListaDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
            PageRequest.of(page, size) 
        :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Categoria> categorias = categoriaRepositorio.findAll(pageable);
        if(categorias.isEmpty()) throw new NoContentException("La Categoria esta vacia");
        return categorias.stream().map(categoria -> modelMapper.map(categoria, CategoriaListaDTO.class))
        .collect(Collectors.toList());         
    }

    @Override
    public long count() {
        return categoriaRepositorio.count();
    }

}
