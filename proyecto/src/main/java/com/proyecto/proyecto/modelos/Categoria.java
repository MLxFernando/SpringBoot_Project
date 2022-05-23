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
@Table(name="TBL_CATEGORIAS")
@Getter
@Setter

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOMBRE",nullable = false, length = 10)
    private String nombre; 
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "TIPO")
    private String tipo;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

}
