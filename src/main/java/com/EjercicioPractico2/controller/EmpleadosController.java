package com.EjercicioPractico2.controller;

import com.EjercicioPractico2.domain.Empleados;
import com.EjercicioPractico2.service.EmpleadosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/empleado")
public class EmpleadosController {
    
    @Autowired
    private EmpleadosService empleadoService; 

    @GetMapping("/listado")
    public String mostrarEmpleados(Model model) {
        var empleados = empleadoService.getEmpleados();
        model.addAttribute("empleados", empleados);
        model.addAttribute("totalEmpleados", empleados.size());
        return "/empleado/listado";
    }
    
    @GetMapping("/nuevo")
    public String agregarEmpleado(Model model) {
        model.addAttribute("empleado", new Empleados());
        return "/empleado/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleados empleado) {
        empleadoService.saveEmpleados(empleado);
        return "redirect:/empleado/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable("id") Long id) {
        empleadoService.deleteEmpleados(id);
        return "redirect:/empleado/listado";
    }

    @GetMapping("/modificar/{id}")
public String modificarEmpleado(@PathVariable("id") Long id, Model model) {
    Empleados empleado = empleadoService.getEmpleados(id);
    model.addAttribute("empleado", empleado);

    return "/empleado/formulario";
}
}
