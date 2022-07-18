package com.proyecto.proyecto.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.proyecto.dto.NewProductoDTO;
import com.proyecto.proyecto.dto.ProductoDTO;
import com.proyecto.proyecto.excepciones.NoContentException;
import com.proyecto.proyecto.excepciones.ResourceNotFoundException;
import com.proyecto.proyecto.modelos.Categoria;
import com.proyecto.proyecto.modelos.Producto;
import com.proyecto.proyecto.modelos.Proveedor;
import com.proyecto.proyecto.repositorios.CategoriaRepositorio;
import com.proyecto.proyecto.repositorios.ProductoRepositorio;
import com.proyecto.proyecto.repositorios.ProveedorRepositorio;
import com.proyecto.proyecto.servicios.ProductoServicio;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    final ModelMapper modelMapper;
    final CategoriaRepositorio categoriaRepositorio;
    final ProveedorRepositorio proveedorRepositorio;
    final ProductoRepositorio repositorio;

    public ProductoServicioImpl(ProductoRepositorio r, ProveedorRepositorio e, CategoriaRepositorio p, ModelMapper m){
        this.modelMapper = m;
        this.repositorio = r;
        this.categoriaRepositorio = p;
        this.proveedorRepositorio = e;
    }

    @Override
    @Transactional
    public List<ProductoDTO> create(Long idCategoria, Long idProveedor, List<NewProductoDTO> productos) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria).orElseThrow(()-> new ResourceNotFoundException("Categoria no valida"));
        Proveedor proveedor = proveedorRepositorio.findById(idProveedor).orElseThrow(()-> new ResourceNotFoundException("Proveedor no valido"));
        proveedor.setCategoria(categoria);
        List<ProductoDTO> result = new ArrayList<ProductoDTO>();
        for(NewProductoDTO pro : productos){
            Producto producto = modelMapper.map(pro, Producto.class);
            producto.setProveedor(proveedor);
            repositorio.save(producto);
            result.add(modelMapper.map(producto, ProductoDTO.class));
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> list(Long idCategoria, Long idProveedor) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria).orElseThrow(()-> new ResourceNotFoundException("Categoria no encontrada"));
        Proveedor proveedor = proveedorRepositorio.findById(idProveedor).orElseThrow(()-> new ResourceNotFoundException("Proveedor no encontrado"));
        proveedor.setCategoria(categoria);
        if(proveedor.getProductos().isEmpty()) throw new NoContentException("Producto vacio");
        return proveedor.getProductos().stream().map(pr -> modelMapper.map(pr, ProductoDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void remove(Long idCategoria, Long idProveedor) {
        Categoria categoria = categoriaRepositorio.findById(idCategoria).orElseThrow(()-> new ResourceNotFoundException("Categoria no valida"));
        Proveedor proveedor = proveedorRepositorio.findById(idProveedor).orElseThrow(()-> new ResourceNotFoundException("Proveedor no encontrado"));
        proveedor.setCategoria(categoria);
        if(proveedor.getProductos().isEmpty()) throw new NoContentException("Producto vacio");
        proveedor.getProductos().forEach(pr -> {
            repositorio.delete(pr);            
        });                      
    }
    
}
