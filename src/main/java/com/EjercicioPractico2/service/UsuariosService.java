package com.EjercicioPractico2.service;

import com.EjercicioPractico2.domain.Usuarios;
import java.util.List;

public interface UsuariosService {

    // Obtener un listado de usuarios
    List<Usuarios> getUsuarios();

    // Obtener un usuario por su ID
    Usuarios getUsuarios(Long id);

    // Guardar o actualizar un usuario
    void saveUsuarios(Usuarios usuario);

    // Eliminar un usuario por su ID
    void deleteUsuarios(Long id);
    
}
