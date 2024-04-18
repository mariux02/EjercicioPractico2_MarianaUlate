package com.EjercicioPractico2.service.impl;

import com.EjercicioPractico2.dao.EmpleadosDao;
import com.EjercicioPractico2.domain.Empleados;
import com.EjercicioPractico2.service.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosServiceImpl implements EmpleadosService {

    @Autowired
    private EmpleadosDao empleadosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleados> getEmpleados() {
        return empleadosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados getEmpleados(Long id) {
        Optional<Empleados> empleadoOptional = empleadosDao.findById(id);
        return empleadoOptional.orElse(null);
    }

    @Override
    @Transactional
    public void saveEmpleados(Empleados empleado) {
        empleadosDao.save(empleado);
    }

    @Override
    @Transactional
    public void deleteEmpleados(Long id) {
        empleadosDao.deleteById(id);
    }
}

