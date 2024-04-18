package com.EjercicioPractico2.controller;


import com.EjercicioPractico2.domain.Hoteles;
import com.EjercicioPractico2.service.HotelesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/hotel")
public class HotelesController {
    
    @Autowired
    private HotelesService hotelService; 

    @GetMapping("/listado")
    public String mostrarHoteles(Model model) {
        var hoteles = hotelService.getHoteles();
        model.addAttribute("hoteles", hoteles);
        model.addAttribute("totalHoteles", hoteles.size());
        return "/hotel/listado";
    }
    
    @GetMapping("/nuevo")
    public String agregarHotel(Model model) {
        model.addAttribute("hotel", new Hoteles());
        return "/hotel/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarHotel(@ModelAttribute("hotel") Hoteles hotel) {
        hotelService.saveHoteles(hotel);
        return "redirect:/hotel/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHotel(@PathVariable("id") Long id) {
        hotelService.deleteHoteles(id);
        return "redirect:/hotel/listado";
    }

    @GetMapping("/modificar/{id}")
public String modificarHotel(@PathVariable("id") Long id, Model model) {
    Hoteles hotel = hotelService.getHoteles(id);
    model.addAttribute("hotel", hotel);

    return "/hotel/formulario";
}
}