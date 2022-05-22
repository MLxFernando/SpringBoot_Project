package com.proyecto.proyecto.modelos;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_PROVEEDORES")
@Getter
@Setter

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ESTADO",nullable = false, length = 10)
    private String estado; 
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TIPO")
    private String tipo;

    @OneToMany(mappedBy = "proveedor")
    private List<Vendedor> vendedores;
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

}
