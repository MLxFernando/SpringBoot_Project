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
@Table(name="TBL_VENDEDORES")
@Getter
@Setter
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CEDULA",nullable = false, length = 10)
    private int cedula; 
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONO")    
    private int telefono;

    @ManyToOne
    @JoinColumn(name="CLIENTE_ID", nullable=false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="PRODUCTO_ID", nullable=false)
    private Producto producto;

}
