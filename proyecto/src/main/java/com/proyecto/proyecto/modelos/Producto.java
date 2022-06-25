package com.proyecto.proyecto.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_PRODUCTOS")
@Getter
@Setter

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOMBRE",nullable = false, length = 100)
    private String nombre; 
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "TIPO")
    private String tipo;

    @ManyToOne
    @JoinColumn(name="PROVEEDOR_ID", nullable=false)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name="CATEGORIA_ID", nullable=false)
    private Categoria categoria;

}
