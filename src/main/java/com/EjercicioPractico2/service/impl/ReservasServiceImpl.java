package com.EjercicioPractico2.service.impl;

import com.EjercicioPractico2.dao.ReservasDao;
import com.EjercicioPractico2.domain.Reservas;
import com.EjercicioPractico2.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    private ReservasDao reservasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservas() {
        return reservasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Reservas getReservas(Long id) {
        Optional<Reservas> reservaOptional = reservasDao.findById(id);
        return reservaOptional.orElse(null);
    }

    @Override
    @Transactional
    public void saveReservas(Reservas reserva) {
        reservasDao.save(reserva);
    }

    @Override
    @Transactional
    public void deleteReservas(Long id) {
        reservasDao.deleteById(id);
    }
}
