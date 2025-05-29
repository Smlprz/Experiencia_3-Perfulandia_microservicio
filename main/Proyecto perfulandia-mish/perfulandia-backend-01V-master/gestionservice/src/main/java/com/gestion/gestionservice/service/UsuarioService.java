package com.gestion.gestionservice.service;

import com.gestion.gestionservice.model.Usuario;
import com.gestion.gestionservice.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }

    public Usuario guardar(Usuario usuario) {
        return repo.save(usuario);
    }

    public Usuario buscar(String horario) {
        return repo.findById(horario).orElse(null);
    }

    public void eliminar(String horario) {
        repo.deleteById(horario);
    }

}
