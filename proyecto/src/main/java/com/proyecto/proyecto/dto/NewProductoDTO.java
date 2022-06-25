package com.proyecto.proyecto.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewProductoDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @NotNull(message = "El precio no puede ser nulo")
    private double precio; 
    private String marca;
    private String cantidad;
    private String tipo;     
}
