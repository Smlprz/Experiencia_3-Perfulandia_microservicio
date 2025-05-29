package com.gestion.gestionservice.model;

import jakarta.persistence.*;
import lombok.*;
//...
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String horario;
    private String personal;
    private String proveedores;
}
