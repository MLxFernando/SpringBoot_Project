package com.proyecto.proyecto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaListaDTO {
    private Long id;
    private String nombre;
    private String descripcion;    
    private String tipo; 
}
