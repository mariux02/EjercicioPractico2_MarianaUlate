package com.EjercicioPractico2.service.impl;

import com.EjercicioPractico2.dao.PreguntaDao;
import com.EjercicioPractico2.domain.Pregunta;
import com.EjercicioPractico2.service.PreguntaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PreguntaServiceImpl implements PreguntaService {
    
    @Autowired
    private PreguntaDao preguntaDao;

    @Override
    @Transactional(readOnly=true)
    public List<Pregunta> getPreguntas() {
        var lista=preguntaDao.findAll(); //Se va a guardar en esta lista
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Pregunta getPregunta(Pregunta pregunta) {
        return preguntaDao.findById(pregunta.getIdPregunta()).orElse(null);
    }

    @Override
    @Transactional //Metodo de tipo transaccional porque le voy a preguntar a la bd sobre la info si existe me la devuelve
    public void save(Pregunta pregunta) {
        preguntaDao.save(pregunta);
    }

    @Override
    @Transactional
    public void delete(Pregunta pregunta) {
        preguntaDao.delete(pregunta);
    }

}