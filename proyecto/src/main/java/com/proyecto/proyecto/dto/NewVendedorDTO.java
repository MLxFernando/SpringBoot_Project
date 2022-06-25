package com.proyecto.proyecto.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewVendedorDTO {
    @NotNull(message = "La cedula no puede ser nula")
    private Integer cedula;
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotNull(message = "El email no puede ser nulo")
    private String email;   
    @NotNull(message = "El telefono no puede ser nulo")
    private Integer telefono;
}
