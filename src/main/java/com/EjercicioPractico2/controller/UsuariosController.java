package com.EjercicioPractico2.controller;

import com.EjercicioPractico2.domain.Usuarios;
import com.EjercicioPractico2.service.UsuariosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuarioService; 

    @GetMapping("/listado")
    public String mostrarUsuarios(Model model) {
        var usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuarios/listado";
    }
    
    @GetMapping("/nuevo")
    public String agregarUsuario(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "/usuarios/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuarios usuario) {
        usuarioService.saveUsuarios(usuario);
        return "redirect:/usuarios/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteUsuarios(id);
        return "redirect:/usuarios/listado";
    }

    @GetMapping("/modificar/{id}")
public String modificarUsuario(@PathVariable("id") Long id, Model model) {
    Usuarios usuario = usuarioService.getUsuarios(id);
    model.addAttribute("usuario", usuario);

    return "/usuarios/formulario";
}
}
