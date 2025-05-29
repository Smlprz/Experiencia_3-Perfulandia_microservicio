package com.gestion.gestionservice.service;

import com.gestion.gestionservice.model.Sucursal;
import com.gestion.gestionservice.repository.SucursalRepository;
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

    public Sucursal buscar(String horario) {
        return repo.findById(horario).orElse(null);
    }

    public void eliminar(String horario) {
        repo.deleteById(horario);
    }

}
