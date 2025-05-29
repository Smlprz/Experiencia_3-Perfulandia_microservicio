package com.perfulandia.gestionservice.service;

import com.perfulandia.gestionservice.model.Sucursal;
import com.perfulandia.gestionservice.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    private final SucursalRepository repo;
    public SucursalService(SucursalRepository repo) {
        this.repo = repo;
    }

    public List<Sucursal> listar() {
        return repo.findAll();
    }

    public Sucursal guardar(Sucursal sucursal) {
        return repo.save(sucursal);
    }

    public Sucursal buscar(long id) {
        return repo.findById(id).orElse(null);

    }
//...
}
