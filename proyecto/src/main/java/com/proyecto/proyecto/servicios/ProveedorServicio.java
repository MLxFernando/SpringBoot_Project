package com.proyecto.proyecto.servicios;

import java.util.List;

import com.proyecto.proyecto.dto.NewProveedorDTO;
import com.proyecto.proyecto.dto.ProveedorCategoriaDTO;
import com.proyecto.proyecto.dto.ProveedorDTO;

public interface ProveedorServicio {
    
    public ProveedorDTO create(Long idCategoria, NewProveedorDTO proveedorDTO);
    public ProveedorCategoriaDTO retrieve(Long idCategoria,Long id);
    public ProveedorCategoriaDTO update(ProveedorDTO proveedorDTO, Long idCategoria,Long id);
    public void delete(Long idCategoria, Long id);
    public long count();

    public List<ProveedorDTO> list(Long idCategoria);
}