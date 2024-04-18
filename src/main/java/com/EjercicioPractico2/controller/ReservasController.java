package com.EjercicioPractico2.controller;

import com.EjercicioPractico2.domain.Reservas;
import com.EjercicioPractico2.service.ReservasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/reserva")
public class ReservasController {
    
    @Autowired
    private ReservasService reservaService; 

    @GetMapping("/listado")
    public String mostrarReservas(Model model) {
        var reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        model.addAttribute("totalReservas", reservas.size());
        return "/reserva/listado";
    }
    
    @GetMapping("/nuevo")
    public String agregarReserva(Model model) {
        model.addAttribute("reserva", new Reservas());
        return "/reserva/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute("reserva") Reservas reserva) {
        reservaService.saveReservas(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable("id") Long id) {
        reservaService.deleteReservas(id);
        return "redirect:/reserva/listado";
    }

   @GetMapping("/modificar/{id}")
public String modificarReserva(@PathVariable("id") Long id, Model model) {
    Reservas reserva = reservaService.getReservas(id);
    model.addAttribute("reserva", reserva);
    return "/reserva/formulario";
}
}

