package com.ipn.mx.inventario.services.impl;

import com.ipn.mx.inventario.domain.entidades.Categorias;
import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.repositorios.CategoriaRepository;
import com.ipn.mx.inventario.domain.repositorios.ProductoRepository;
import com.ipn.mx.inventario.services.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ProductoRepository productoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public Categorias crearCategoria(Categorias categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public void eliminarCategoria(int id) {
        if (!categoriaRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoría no encontrada con ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProductosPorCategoria(int idCategoria) {
        if (!categoriaRepository.existsById(idCategoria)) {
            throw new EntityNotFoundException("Categoría no encontrada con ID: " + idCategoria);
        }
        return productoRepository.findByCategorias_IdCategoria(idCategoria);
    }
}
