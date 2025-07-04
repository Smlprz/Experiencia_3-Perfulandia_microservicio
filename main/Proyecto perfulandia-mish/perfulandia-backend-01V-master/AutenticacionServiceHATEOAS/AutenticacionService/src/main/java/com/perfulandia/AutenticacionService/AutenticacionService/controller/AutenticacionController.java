package com.perfulandia.AutenticacionService.AutenticacionService.controller;

import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import com.perfulandia.AutenticacionService.AutenticacionService.repository.AutenticacionRepository;
import com.perfulandia.AutenticacionService.AutenticacionService.service.AutenticationService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import com.perfulandia.AutenticacionService.AutenticacionService.assembler.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/login")
public class AutenticacionController {
    private final AutenticationService service;
    private final UsuarioModelAssembler assembler;

    public AutenticacionController(AutenticationService service, UsuarioModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody Usuario usuario) {
        Usuario iniciosesion = service.autenticar(usuario.getCorreo(), usuario.getContrasena());
        if (iniciosesion != null) {
            EntityModel<Usuario> entityModel = assembler.toModel(iniciosesion);

            return ResponseEntity
                    .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                    .body(entityModel);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña o usuario incorrecto");
        }
    }
}