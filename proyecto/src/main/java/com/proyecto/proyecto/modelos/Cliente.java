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
@Table(name= "TBL_CLIENTES")
@Getter
@Setter

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "CEDULA",nullable = false, length = 10)
    private Integer cedula; 
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TELEFONO",nullable = false, length = 10)
    private Integer telefono;
    @Column(name = "DIRECCION", nullable = false, length = 100)
    private String direccion;
    @Column(name = "EMAIL",nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Vendedor> vendedores;

}