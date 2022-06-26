package com.proyecto.proyecto.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewCategoriaDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotNull(message = "La descripcion no puede ser nula")
    private String descripcion;    
    private String tipo;      
}