package com.perfulandia.AutenticacionService.AutenticacionService.controller;
import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import com.perfulandia.AutenticacionService.AutenticacionService.repository.AutenticacionRepository;
import com.perfulandia.AutenticacionService.AutenticacionService.service.AutenticationService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController
@RequestMapping("/api/login")
public class AutenticacionController {
    private final AutenticationService service;
    public AutenticacionController(AutenticationService service) {
    this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody Usuario usuario) {
        Usuario iniciosesion = service.autenticar(usuario.getCorreo(), usuario.getContrasena());
        if (iniciosesion != null) {
            return ResponseEntity.ok(iniciosesion);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña o usuario incorrecto");
        }
    }
}
