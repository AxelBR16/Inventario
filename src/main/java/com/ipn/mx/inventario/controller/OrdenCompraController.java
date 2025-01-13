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
public class OrdenCompraController {

    private final OrdenCompraService ordenCompraService;
    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;

    @PostMapping
    public ResponseEntity<OrdenCompra> crearOrdenCompra(@Valid @RequestBody OrdenCompraDTO ordenCompraDTO) {

        // Busca el producto por ID
        Producto producto = productoRepository.findById(ordenCompraDTO.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Busca el proveedor por ID
        Proveedor proveedor = proveedorRepository.findById(ordenCompraDTO.getIdProveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        OrdenCompra nuevaOrdenCompra = new OrdenCompra();

        nuevaOrdenCompra.setProducto(producto);
        nuevaOrdenCompra.setProveedor(proveedor);
        nuevaOrdenCompra.setCantidad(ordenCompraDTO.getCantidad());
        nuevaOrdenCompra.setPrecioUnitario(ordenCompraDTO.getPrecioUnitario());
        nuevaOrdenCompra.setFechaEntrega(ordenCompraDTO.getFechaEntrega());

        OrdenCompra ordenCompraGuardada = ordenCompraService.saveMovimiento(nuevaOrdenCompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(ordenCompraGuardada);
    }

    @GetMapping
    public List<OrdenCompra> obtenerTodas() {
        return ordenCompraService.listarTodas();
    }

}