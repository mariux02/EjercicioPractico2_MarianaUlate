package com.EjercicioPractico2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "empleados")

public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cargo")
    private String cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hoteles hotel;
    
    public Empleados() {
    }

    public Empleados(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

}
