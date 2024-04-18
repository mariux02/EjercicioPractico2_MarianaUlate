package com.EjercicioPractico2.service;

import com.EjercicioPractico2.domain.Reservas;
import java.util.List;

public interface ReservasService {

    // Obtener un listado de reservas
    List<Reservas> getReservas();

    // Obtener una reserva por su ID
    Reservas getReservas(Long id);

    // Guardar o actualizar una reserva
    void saveReservas(Reservas reserva);

    // Eliminar una reserva por su ID
    void deleteReservas(Long id);
    
}
