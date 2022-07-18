package com.proyecto.proyecto.servicios;

import java.util.List;

import com.proyecto.proyecto.dto.CategoriaDTO;
import com.proyecto.proyecto.dto.CategoriaListaDTO;
import com.proyecto.proyecto.dto.NewCategoriaDTO;


public interface CategoriaServicio {
    
    public CategoriaDTO create(NewCategoriaDTO categoriaDTO);
    public CategoriaDTO retrieve(Long id);
    public CategoriaDTO update(CategoriaDTO categoriaDTO, Long id);
    public void delete(Long id);
    public long count();

    public List<CategoriaListaDTO> list(int page, int size, String sort);
}