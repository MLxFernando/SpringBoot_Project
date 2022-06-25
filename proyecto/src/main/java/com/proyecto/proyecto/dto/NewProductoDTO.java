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
    @NotNull(message = "La marca no puede ser nula")
    private String marca;
    private Integer cantidad;
    private String tipo;     
}
