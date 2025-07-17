package com.perfulandia.compraservice.service;

import com.perfulandia.compraservice.model.Compra;
import com.perfulandia.compraservice.repository.CompraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompraServiceTest {

    @Mock
    private CompraRepository compraRepository;

    @InjectMocks
    private CompraService compraService;

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
    void obtenerTodas() {
        // Arrange
        when(compraRepository.findAll()).thenReturn(Arrays.asList(compra));

        // Act
        List<Compra> resultado = compraService.obtenerTodas();

        // Assert
        assertEquals(1, resultado.size());
        verify(compraRepository, times(1)).findAll();
    }

    @Test
    void obtenerPorId() {
        // Arrange
        when(compraRepository.findById(1L)).thenReturn(Optional.of(compra));

        // Act
        Optional<Compra> resultado = compraService.obtenerPorId(1L);

        // Assert
        assertTrue(resultado.isPresent());
        assertEquals("Juan Perez", resultado.get().getClienteNombre());
        verify(compraRepository, times(1)).findById(1L);
    }

    @Test
    void registrarCompra() {
        // Arrange
        when(compraRepository.save(compra)).thenReturn(compra);

        // Act
        Compra resultado = compraService.registrarCompra(compra);

        // Assert
        assertNotNull(resultado);
        assertEquals("Juan Perez", resultado.getClienteNombre());
        verify(compraRepository, times(1)).save(compra);
    }

    @Test
    void marcarDevuelta() {
        // Arrange
        when(compraRepository.findById(1L)).thenReturn(Optional.of(compra));
        when(compraRepository.save(any(Compra.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Compra resultado = compraService.marcarDevuelta(1L);

        // Assert
        assertTrue(resultado.isDevuelto());
        verify(compraRepository, times(1)).findById(1L);
        verify(compraRepository, times(1)).save(any(Compra.class));
    }

    @Test
    void marcarReembolsada() {
        // Arrange
        when(compraRepository.findById(1L)).thenReturn(Optional.of(compra));
        when(compraRepository.save(any(Compra.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Compra resultado = compraService.marcarReembolsada(1L);

        // Assert
        assertTrue(resultado.isReembolsado());
        verify(compraRepository, times(1)).findById(1L);
        verify(compraRepository, times(1)).save(any(Compra.class));
    }
}