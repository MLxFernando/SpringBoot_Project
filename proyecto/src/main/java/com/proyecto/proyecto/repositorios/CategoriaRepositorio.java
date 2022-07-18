package com.proyecto.proyecto.repositorios;

import com.proyecto.proyecto.modelos.Categoria;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria,Long>{
       
}
