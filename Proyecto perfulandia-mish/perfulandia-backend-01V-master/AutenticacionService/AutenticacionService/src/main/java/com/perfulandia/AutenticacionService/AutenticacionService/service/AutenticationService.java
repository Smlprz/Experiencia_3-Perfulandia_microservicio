package com.perfulandia.AutenticacionService.AutenticacionService.service;

import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import java.util.List;

import com.perfulandia.AutenticacionService.AutenticacionService.repository.AutenticacionRepository;
import org.springframework.stereotype.Service;

@Service

public class AutenticationService {
    private final AutenticacionRepository repo;
    public AutenticationService(AutenticacionRepository repo){
        this.repo=repo;
    }
    public Usuario buscar(long id){
        return repo.findById(id).orElse(null);
    }}


