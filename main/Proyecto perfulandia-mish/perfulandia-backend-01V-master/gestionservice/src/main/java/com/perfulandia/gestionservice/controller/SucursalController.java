package com.perfulandia.gestionservice.controller;

import com.perfulandia.gestionservice.model.Sucursal;
import com.perfulandia.gestionservice.service.SucursalService;
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

    @GetMapping("/{id}")
    public Sucursal buscar(@PathVariable long id){
        return service.buscar(id);
    }

}
