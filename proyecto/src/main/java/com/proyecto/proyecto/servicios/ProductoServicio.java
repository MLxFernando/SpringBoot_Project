package com.proyecto.proyecto.servicios;

import java.util.List;

import com.proyecto.proyecto.dto.NewProductoDTO;
import com.proyecto.proyecto.dto.ProductoDTO;

public interface ProductoServicio {
    
    public ProductoDTO create(NewProductoDTO productoDTO);
    public ProductoDTO retrieve(Long id);
    public ProductoDTO update(ProductoDTO productoDTO, Long id);
    public void delete(Long id);

    public List<ProductoDTO> list();
}