package com.EjercicioPractico2.service.impl;

import com.EjercicioPractico2.dao.UsuariosDao;
import com.EjercicioPractico2.domain.Usuarios;
import com.EjercicioPractico2.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosDao usuariosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios() {
        return usuariosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarios(Long id) {
        Optional<Usuarios> usuarioOptional = usuariosDao.findById(id);
        return usuarioOptional.orElse(null);
    }

    @Override
    @Transactional
    public void saveUsuarios(Usuarios usuario) {
        usuariosDao.save(usuario);
    }

    @Override
    @Transactional
    public void deleteUsuarios(Long id) {
        usuariosDao.deleteById(id);
    }
}
