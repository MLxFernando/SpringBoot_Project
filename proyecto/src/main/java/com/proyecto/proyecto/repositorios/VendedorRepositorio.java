package com.proyecto.proyecto.repositorios;

import com.proyecto.proyecto.modelos.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepositorio extends JpaRepository<Vendedor,Long> {
    
}
