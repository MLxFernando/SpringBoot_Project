package com.proyecto.proyecto.repositorios;

import com.proyecto.proyecto.modelos.Categoria;
import com.proyecto.proyecto.modelos.Proveedor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor,Long>{
    public List<Proveedor> findByCategoria(Categoria categoria);
}
