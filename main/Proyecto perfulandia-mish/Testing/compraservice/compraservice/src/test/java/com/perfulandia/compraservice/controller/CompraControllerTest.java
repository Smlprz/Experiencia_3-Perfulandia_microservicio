package com.perfulandia.compraservice.controller;

import com.perfulandia.compraservice.model.Compra;
import com.perfulandia.compraservice.service.CompraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompraControllerTest {

    @Mock
    private CompraService compraService;

    @InjectMocks
    private CompraController compraController;

    private Compra compra;

    @BeforeEach
    void setUp() {
        compra = Compra.builder()
                .id(1L)
                .clienteNombre("Juan Perez")
                .clienteRut("12345678-9")
                .totalCompra(10000.0)
                .metodoPago("Tarjeta")
                .pagado(true)
                .devuelto(false)
                .reembolsado(false)
                .boletaElectronica("B123456")
                .fechaCompra(null)
                .build();
    }

    @Test
    void listarCompras() {
        // Arrange
        List<Compra> compras = Arrays.asList(compra);
        when(compraService.obtenerTodas()).thenReturn(compras);

        // Act
        List<Compra> resultado = compraController.listarCompras();

        // Assert
        assertEquals(1, resultado.size());
        verify(compraService, times(1)).obtenerTodas();
    }

    @Test
    void obtenerCompra() {
        // Arrange
        when(compraService.obtenerPorId(1L)).thenReturn(Optional.of(compra));

        // Act
        Optional<Compra> resultado = compraController.obtenerCompra(1L);

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("Juan Perez", resultado.get().getClienteNombre());
        verify(compraService, times(1)).obtenerPorId(1L);
    }

    @Test
    void nuevaCompra() {
        // Arrange
        when(compraService.registrarCompra(compra)).thenReturn(compra);

        // Act
        Compra resultado = compraController.nuevaCompra(compra);

        // Assert
        assertNotNull(resultado);
        assertEquals("Juan Perez", resultado.getClienteNombre());
        verify(compraService, times(1)).registrarCompra(compra);
    }

    @Test
    void devolverCompra() {
        // Arrange
        Compra compraDevuelta = compra;
        compraDevuelta.setDevuelto(true);
        when(compraService.marcarDevuelta(1L)).thenReturn(compraDevuelta);

        // Act
        Compra resultado = compraController.devolverCompra(1L);

        // Assert
        assertTrue(resultado.isDevuelto());
        verify(compraService, times(1)).marcarDevuelta(1L);
    }

    @Test
    void reembolsarCompra() {
        // Arrange
        Compra compraReembolsada = compra;
        compraReembolsada.setReembolsado(true);
        when(compraService.marcarReembolsada(1L)).thenReturn(compraReembolsada);

        // Act
        Compra resultado = compraController.reembolsarCompra(1L);

        // Assert
        assertTrue(resultado.isReembolsado());
        verify(compraService, times(1)).marcarReembolsada(1L);
    }
}