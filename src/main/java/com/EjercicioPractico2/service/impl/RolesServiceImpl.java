package com.EjercicioPractico2.service.impl;

import com.EjercicioPractico2.dao.RolesDao;
import com.EjercicioPractico2.domain.Roles;
import com.EjercicioPractico2.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDao rolesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Roles> getRoles() {
        return rolesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Roles getRoles(Long id) {
        Optional<Roles> rolOptional = rolesDao.findById(id);
        return rolOptional.orElse(null);
    }

    @Override
    @Transactional
    public void saveRoles(Roles rol) {
        rolesDao.save(rol);
    }

    @Override
    @Transactional
    public void deleteRoles(Long id) {
        rolesDao.deleteById(id);
    }
}
