package com.EjercicioPractico2.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")

public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cliente_nombre")
    private String clienteNombre;

    @Column(name = "num_huespedes")
    private int numHuespedes;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hoteles hotel;

    @Column(name = "numero_cedula")
    private String numeroCedula;

    public Reservas() {
    }

    public Reservas(String clienteNombre, int numHuespedes, Date fechaIngreso, Date fechaSalida, String numeroCedula) {
        this.clienteNombre = clienteNombre;
        this.numHuespedes = numHuespedes;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.numeroCedula = numeroCedula;
    }
}
