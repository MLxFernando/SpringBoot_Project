package com.proyecto.proyecto.repositorios;

import com.proyecto.proyecto.modelos.Producto;
import com.proyecto.proyecto.modelos.Proveedor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Long>{
    public List<Producto> findByProveedor(Proveedor proveedor);
}
