package com.perfulandia.AutenticacionService.AutenticacionService.assembler;

import com.perfulandia.AutenticacionService.AutenticacionService.controller.AutenticacionController;
import com.perfulandia.AutenticacionService.AutenticacionService.model.Usuario;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>> {

    @Override
    public EntityModel<Usuario> toModel(Usuario usuario) {
        return EntityModel.of(usuario,
                linkTo(methodOn(AutenticacionController.class).autenticar(usuario)).withSelfRel());
    }
}