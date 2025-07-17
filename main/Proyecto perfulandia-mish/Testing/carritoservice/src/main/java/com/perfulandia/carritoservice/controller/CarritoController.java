package com.perfulandia.carritoservice.controller;

import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.service.CarritoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@Tag(name = "Carrito Controller", description = "Operaciones para gestionar el carrito de compras")
public class CarritoController {

    private final CarritoService carritoService;

    @Autowired
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @Operation(summary = "Obtener todos los ítems del carrito")
    @GetMapping
    public List<Carrito> listarCarrito() {
        return carritoService.listar();
    }

    @Operation(summary = "Agregar un ítem al carrito")
    @PostMapping
    public Carrito agregarItem(@RequestBody Carrito item) {
        return carritoService.addItem(item);
    }

    @Operation(summary = "Eliminar un ítem específico del carrito")
    @DeleteMapping("/{id}")
    public void eliminarItem(@PathVariable Long id) {
        carritoService.removeItem(id);
    }

    @Operation(summary = "Limpiar el carrito completo")
    @DeleteMapping
    public void limpiarCarrito() {
        carritoService.clearCarrito();
    }
}