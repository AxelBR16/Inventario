package com.ipn.mx.inventario.controller;


import com.ipn.mx.inventario.domain.entidades.Categorias;
import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    private final CategoriaService categoriaService;

    public CategoriasController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categorias> crearCategoria(@RequestBody Categorias categoria) {
        Categorias nuevaCategoria = categoriaService.crearCategoria(categoria);
        return ResponseEntity.ok(nuevaCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable int id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/productos")
    public ResponseEntity<List<Producto>> listarProductosPorCategoria(@PathVariable int id) {
        List<Producto> productos = categoriaService.listarProductosPorCategoria(id);
        return ResponseEntity.ok(productos);
    }
}