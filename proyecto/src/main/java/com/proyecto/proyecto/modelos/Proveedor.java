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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOMBRE",nullable = false, length = 100)
    private String nombre; 
    @Column(name = "TELEFONO")
    private int telefono;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TIPO")
    private String tipo;

    @OneToMany(mappedBy = "proveedor")
    private List<Vendedor> vendedores;
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

}
