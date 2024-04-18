package com.EjercicioPractico2.service;

import com.EjercicioPractico2.domain.Roles;
import java.util.List;

public interface RolesService {

    // Obtener un listado de roles
    List<Roles> getRoles();

    // Obtener un rol por su ID
    Roles getRoles(Long id);

    // Guardar o actualizar un rol
    void saveRoles(Roles rol);

    // Eliminar un rol por su ID
    void deleteRoles(Long id);
    
}

