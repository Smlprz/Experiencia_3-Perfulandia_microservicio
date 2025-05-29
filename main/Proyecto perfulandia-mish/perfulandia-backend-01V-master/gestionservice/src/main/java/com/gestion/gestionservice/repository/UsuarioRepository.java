package com.gestion.gestionservice.repository;

import com.gestion.gestionservice.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
