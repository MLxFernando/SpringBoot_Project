package com.proyecto.proyecto.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProveedorCategoriaDTO extends ProveedorDTO{
    private CategoriaDTO categoria;   
}
