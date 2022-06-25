package com.proyecto.proyecto.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewProveedorDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotNull(message = "El telefono no puede ser nulo")
    private Integer telefono;
    @NotNull(message = "La direccion no puede ser nula")
    private String direccion;
    private String tipo;     
}