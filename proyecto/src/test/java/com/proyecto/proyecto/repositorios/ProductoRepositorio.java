package com.proyecto.proyecto.repositorios;

import com.proyecto.proyecto.modelos.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Long>{
    
}
