package com.proyecto.proyecto.repositorios;

import com.proyecto.proyecto.modelos.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VendedorRepositorio extends JpaRepository<Vendedor,Long> {
    
}
