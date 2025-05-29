package com.gestion.gestionservice.controller;

import com.gestion.gestionservice.model.Usuario;
import com.gestion.gestionservice.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @GetMapping
    public Usuario buscar(@PathVariable String horario){
        return service.buscar(horario);
    }

    @GetMapping
    public void eliminar(@PathVariable String horario){
        service.eliminar(horario);
    }
}
