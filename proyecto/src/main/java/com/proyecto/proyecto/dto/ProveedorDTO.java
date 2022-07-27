package com.proyecto.proyecto.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO extends NewProveedorDTO {
    private Long id;
    private List<ProductoDTO>productos;
}
