package com.proyecto.proyecto.servicios;

import java.util.List;

import com.proyecto.proyecto.dto.NewProveedorDTO;
import com.proyecto.proyecto.dto.ProveedorDTO;

public interface ProveedorServicio {
    
    public ProveedorDTO create(NewProveedorDTO proveedorDTO);
    public ProveedorDTO retrieve(Long id);
    public ProveedorDTO update(ProveedorDTO proveedorDTO, Long id);
    public void delete(Long id);

    public List<ProveedorDTO> list();
}