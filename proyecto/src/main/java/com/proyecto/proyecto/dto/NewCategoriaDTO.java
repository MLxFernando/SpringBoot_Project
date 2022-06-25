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
    private String description;    
    private String tipo;      
}