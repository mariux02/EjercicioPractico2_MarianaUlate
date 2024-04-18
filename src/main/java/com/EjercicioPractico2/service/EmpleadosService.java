package com.EjercicioPractico2.service;

import com.EjercicioPractico2.domain.Empleados;
import java.util.List;

public interface EmpleadosService {

    // Se obtiene un listado de empleados en un List
    public List<Empleados> getEmpleados();
    
    // Se obtiene un empleado, a partir del id de un empleado
    public Empleados getEmpleados(Long id);

    // Se inserta un nuevo empleado si el id del empleado está vacío
    // Se actualiza un empleado si el id del empleado NO está vacío
    public void saveEmpleados(Empleados empleado);

    // Se elimina el empleado que tiene el id pasado por parámetro
    public void deleteEmpleados(Long id);
        
}
