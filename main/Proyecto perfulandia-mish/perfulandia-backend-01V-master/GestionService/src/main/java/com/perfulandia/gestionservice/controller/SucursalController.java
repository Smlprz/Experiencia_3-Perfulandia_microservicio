package com.gestion.gestionservice.controller;

import com.gestion.gestionservice.model.Sucursal;
import com.gestion.gestionservice.service.SucursalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    private final SucursalService service;

    public SucursalController(SucursalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Sucursal> listar() {
        return service.listar();
    }

    @PostMapping
    public Sucursal guardar(@RequestBody Sucursal sucursal) {
        return service.guardar(sucursal);
    }

    @GetMapping
    public Sucursal buscar(@PathVariable String horario){
        return service.buscar(horario);
    }

    @GetMapping
    public void eliminar(@PathVariable String horario){
        service.eliminar(horario);
    }
}
