package com.EjercicioPractico2.dao;

import com.EjercicioPractico2.domain.Hoteles;
import java.util.List;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelesDao extends JpaRepository <Hoteles,Long> {   
}
