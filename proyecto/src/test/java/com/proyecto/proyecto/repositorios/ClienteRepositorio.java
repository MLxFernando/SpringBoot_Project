package com.proyecto.proyecto.repositorios;

import com.proyecto.proyecto.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long>{
    
}
