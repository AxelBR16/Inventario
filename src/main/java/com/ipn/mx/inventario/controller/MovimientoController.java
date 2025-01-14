package com.ipn.mx.inventario.controller;

import com.ipn.mx.inventario.domain.entidades.Movimiento;
import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.TipoMovimiento;
import com.ipn.mx.inventario.dto.MovimientoDTO;
import com.ipn.mx.inventario.services.MovimientoService;
import com.ipn.mx.inventario.services.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

/*
    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private ProductoService productoService;


    @PostMapping
    public ResponseEntity<Movimiento> createMovimiento(@RequestBody MovimientoDTO movimientoDTO) {
        TipoMovimiento tipoMovimiento;
        try {
            tipoMovimiento = TipoMovimiento.valueOf(movimientoDTO.getTipoMovimiento().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de movimiento inválido: " + movimientoDTO.getTipoMovimiento());
        }

        Producto producto = productoService.obtenerPorId(movimientoDTO.getProductoId())
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        Movimiento movimiento = Movimiento.builder()
                .producto(producto)
                .tipoMovimiento(tipoMovimiento)
                .cantidad(movimientoDTO.getCantidad())
                .fecha(LocalDateTime.now()) // Asignar la fecha actual del sistema
                .build();

        Movimiento savedMovimiento = movimientoService.saveMovimiento(movimiento);

        return ResponseEntity.ok(savedMovimiento);
    }



    @GetMapping
    public ResponseEntity<List<Movimiento>> getAllMovimientos() {
        List<Movimiento> movimientos = movimientoService.getAllMovimientos();
        return ResponseEntity.ok(movimientos);
    }
*/
}
