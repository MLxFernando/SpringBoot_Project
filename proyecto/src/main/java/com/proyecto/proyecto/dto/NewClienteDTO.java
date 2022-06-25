package com.proyecto.proyecto.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewClienteDTO {
    @NotNull(message = "La cedula no puede ser nula")
    private Integer cedula;
    @NotNull(message = "El nombre no puede estar vacio")
    private String nombre;
    @NotNull(message = "El telefono no puede estar vacio")
    private Integer telefono;  
    @NotNull(message = "La direccion no puede estar vacio")
    private String direccion;
    @NotNull(message = "El email no puede estar vacio")
    private String email;  
}