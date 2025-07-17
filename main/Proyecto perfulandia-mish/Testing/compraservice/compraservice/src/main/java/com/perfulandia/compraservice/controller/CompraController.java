package com.perfulandia.compraservice.controller;

import com.perfulandia.compraservice.model.Compra;
import com.perfulandia.compraservice.service.CompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/compras")
@Tag(name = "Compra Controller", description = "API para gestionar compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las compras")
    public List<Compra> listarCompras() {
        return compraService.obtenerTodas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una compra por ID")
    public Optional<Compra> obtenerCompra(@PathVariable Long id) {
        return compraService.obtenerPorId(id);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva compra")
    public Compra nuevaCompra(@RequestBody Compra compra) {
        return compraService.registrarCompra(compra);
    }

    @PutMapping("/{id}/devolver")
    @Operation(summary = "Marcar compra como devuelta")
    public Compra devolverCompra(@PathVariable Long id) {
        return compraService.marcarDevuelta(id);
    }

    @PutMapping("/{id}/reembolsar")
    @Operation(summary = "Marcar compra como reembolsada")
    public Compra reembolsarCompra(@PathVariable Long id) {
        return compraService.marcarReembolsada(id);
    }
}