package com.proyecto.proyecto.servicios;

import java.util.List;

import com.proyecto.proyecto.dto.NewVendedorDTO;
import com.proyecto.proyecto.dto.VendedorDTO;

public interface VendedorServicio {
    
    public VendedorDTO create(NewVendedorDTO vendedorDTO);
    public VendedorDTO retrieve(Long id);
    public VendedorDTO update(VendedorDTO vendedorDTO, Long id);
    public void delete(Long id);

    public List<VendedorDTO> list();
}