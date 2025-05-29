package com.perfulandia.carritoservice.controller;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    private final CarritoService carritoService;

    @Autowired
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    // Obtener todos los ítems del carrito
    @GetMapping
    public List<Carrito> listarCarrito() {
        return carritoService.listar();
    }

    // Agregar un ítem al carrito
    @PostMapping
    public Carrito agregarItem(@RequestBody Carrito item) {
        return carritoService.addItem(item);
    }

    // Eliminar un ítem específico del carrito
    @DeleteMapping("/{id}")
    public void eliminarItem(@PathVariable Long id) {
        carritoService.removeItem(id);
    }

    // Limpiar el carrito completo
    @DeleteMapping
    public void limpiarCarrito() {
        carritoService.clearCarrito();
    }
}
