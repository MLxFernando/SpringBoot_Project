package com.proyecto.proyecto.servicios;

import java.util.List;

import com.proyecto.proyecto.dto.NewProductoDTO;
import com.proyecto.proyecto.dto.ProductoDTO;

public interface ProductoServicio {
    
    public List<ProductoDTO> create(Long idCategoria, Long idProveedor,List<NewProductoDTO> list);
    public List<ProductoDTO> list(Long idCategoria, Long idProveedor);
    public void remove(Long idCategoria, Long idProveedor);
}