package com.perfulandia.compraservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clienteNombre;
    private String clienteRut;

    private double totalCompra;

    private String metodoPago; // ejemplo: 'Transferencia', 'Tarjeta', etc.

    private boolean pagado;

    private boolean devuelto;
    private boolean reembolsado;

    private String boletaElectronica; // podría ser un número o un UUID

    private LocalDateTime fechaCompra;
}