package com.ipn.mx.inventario.controller;

import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.TipoMovimiento;
import com.ipn.mx.inventario.dto.OrdenCompraDTO;
import com.ipn.mx.inventario.dto.ProductoDTO;
import com.ipn.mx.inventario.services.OrdenCompraService;
import com.ipn.mx.inventario.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = {"*"})
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public ResponseEntity<Iterable<Producto>> getAllProductos() {
        return ResponseEntity.ok(productoService.getAllProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Integer id) {
        return productoService.getProducto(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody ProductoDTO productoDTO) {
        Producto nuevoProducto = productoService.crearProducto(productoDTO);
        return ResponseEntity.ok(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(
            @PathVariable Integer id,
            @RequestBody @Valid ProductoDTO productoDTO) {
        try {
            Producto productoActualizado = productoService.updateProducto(id, productoDTO);
            return ResponseEntity.ok(productoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        productoService.deleteProducto(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/movimiento")
    public ResponseEntity<Void> registrarMovimiento(
            @PathVariable("id") Integer productoId,
            @RequestParam Integer cantidad,
            @RequestParam TipoMovimiento tipo) {
        try {
            productoService.actualizarStock(productoId, cantidad, tipo);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}/comprar")
    public ResponseEntity<Void> comprarProducto(
            @PathVariable("id") Integer productoId,
            @RequestParam Integer cantidad,
            @RequestParam Integer idProveedor, // Asumimos que el proveedor también se proporciona
            @RequestParam Double total) {

        try {
            OrdenCompraDTO ordenCompraDTO = new OrdenCompraDTO();
            ordenCompraDTO.setIdProveedor(idProveedor);
            ordenCompraDTO.setIdProducto(productoId);
            ordenCompraDTO.setCantidad(cantidad);
            ordenCompraDTO.setTotal(total);
            ordenCompraDTO.setFechaEntrega(LocalDate.now());
            ordenCompraService.crearOrdenCompra(ordenCompraDTO);

            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
