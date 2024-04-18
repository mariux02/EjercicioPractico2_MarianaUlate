package com.EjercicioPractico2.service.impl;

import com.EjercicioPractico2.dao.HotelesDao;
import com.EjercicioPractico2.domain.Hoteles;
import com.EjercicioPractico2.service.HotelesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HotelesServiceImpl implements HotelesService {

    @Autowired
    private HotelesDao hotelesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Hoteles> getHoteles() {
        return hotelesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Hoteles getHoteles(Long id) {
        Optional<Hoteles> hotelOptional = hotelesDao.findById(id);
        return hotelOptional.orElse(null);
    }

    @Override
    @Transactional
    public void saveHoteles(Hoteles hotel) {
        hotelesDao.save(hotel);
    }

    @Override
    @Transactional
    public void deleteHoteles(Long id) {
        hotelesDao.deleteById(id);
    }
}
