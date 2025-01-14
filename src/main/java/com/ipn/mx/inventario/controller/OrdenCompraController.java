package com.ipn.mx.inventario.controller;

import com.ipn.mx.inventario.domain.entidades.OrdenCompra;
import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.Proveedor;


import com.ipn.mx.inventario.domain.repositorios.ProductoRepository;
import com.ipn.mx.inventario.domain.repositorios.ProveedorRepository;
import com.ipn.mx.inventario.dto.OrdenCompraDTO;
import com.ipn.mx.inventario.services.OrdenCompraService;
import com.ipn.mx.inventario.services.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordenes-compra")
@RequiredArgsConstructor
@CrossOrigin(origins = {"*"})
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;

    @GetMapping
    public List<OrdenCompra> obtenerTodas() {
        return ordenCompraService.listarTodas();
    }

}