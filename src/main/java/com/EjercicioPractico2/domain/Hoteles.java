package com.EjercicioPractico2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "hoteles")
public class Hoteles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    public Hoteles() {
    }

    public Hoteles(String nombre, String ubicacion, String descripcion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }
}