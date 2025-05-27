package com.perfulandia.AutenticacionService.AutenticacionService.repository;
import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AutenticacionRepository extends JpaRepository<Usuario, Long> {
}
