package com.perfulandia.compraservice.controller;

import com.perfulandia.compraservice.model.Compra;
import com.perfulandia.compraservice.service.CompraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public List<Compra> listarCompras() {
        return compraService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<Compra> obtenerCompra(@PathVariable Long id) {
        return compraService.obtenerPorId(id);
    }

    @PostMapping
    public Compra nuevaCompra(@RequestBody Compra compra) {
        return compraService.registrarCompra(compra);
    }

    @PutMapping("/{id}/devolver")
    public Compra devolverCompra(@PathVariable Long id) {
        return compraService.marcarDevuelta(id);
    }

    @PutMapping("/{id}/reembolsar")
    public Compra reembolsarCompra(@PathVariable Long id) {
        return compraService.marcarReembolsada(id);
    }
}