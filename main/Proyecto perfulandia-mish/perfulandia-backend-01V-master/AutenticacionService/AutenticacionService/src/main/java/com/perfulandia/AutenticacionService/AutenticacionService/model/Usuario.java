package com.perfulandia.AutenticacionService.AutenticacionService.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Clase usuario para que el sistema de login pueda funcionar
public class Usuario extends RepresentationModel<Usuario> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
}