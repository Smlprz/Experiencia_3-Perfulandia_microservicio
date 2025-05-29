package com.perfulandia.compraservice.service;

import com.perfulandia.compraservice.model.Compra;
import com.perfulandia.compraservice.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    private final CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public List<Compra> obtenerTodas() {
        return compraRepository.findAll();
    }

    public Optional<Compra> obtenerPorId(Long id) {
        return compraRepository.findById(id);
    }

    public Compra registrarCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public Compra marcarDevuelta(Long id) {
        Compra compra = compraRepository.findById(id).orElseThrow();
        compra.setDevuelto(true);
        return compraRepository.save(compra);
    }

    public Compra marcarReembolsada(Long id) {
        Compra compra = compraRepository.findById(id).orElseThrow();
        compra.setReembolsado(true);
        return compraRepository.save(compra);
    }
}