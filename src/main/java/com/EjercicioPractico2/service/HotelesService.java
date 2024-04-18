package com.EjercicioPractico2.service;

import  com.EjercicioPractico2.domain.Hoteles;
import java.util.List;

public interface HotelesService {

    // Obtener un listado de hoteles
    List<Hoteles> getHoteles();

    // Obtener un hotel por su ID
    Hoteles getHoteles(Long id);

    // Guardar o actualizar un hotel
    void saveHoteles(Hoteles hotel);

    // Eliminar un hotel por su ID
    void deleteHoteles(Long id);
    
}

