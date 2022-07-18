package com.proyecto.proyecto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewProductoDTO {
    private String nombre;
    private double precio; 
    private String marca;
    private int cantidad;
    private String tipo;     
}
