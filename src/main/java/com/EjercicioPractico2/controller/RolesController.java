package com.EjercicioPractico2.controller;

import com.EjercicioPractico2.domain.Roles;
import com.EjercicioPractico2.service.RolesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/Roles")
public class RolesController {
    
    @Autowired
    private RolesService rolService; 

    @GetMapping("/listado")
    public String mostrarRoles(Model model) {
        var roles = rolService.getRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("totalRoles", roles.size());
        return "/Roles/listado";
    }
    
    @GetMapping("/nuevo")
    public String agregarRol(Model model) {
        model.addAttribute("rol", new Roles());
        return "/Roles/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarRol(@ModelAttribute("rol") Roles rol) {
        rolService.saveRoles(rol);
        return "redirect:/Roles/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable("id") Long id) {
        rolService.deleteRoles(id);
        return "redirect:/Roles/listado";
    }

    @GetMapping("/modificar/{id}")
public String modificarRol(@PathVariable("id") Long id, Model model) {
    Roles rol = rolService.getRoles(id);
    model.addAttribute("rol", rol);


    return "/Roles/formulario";
}
}
