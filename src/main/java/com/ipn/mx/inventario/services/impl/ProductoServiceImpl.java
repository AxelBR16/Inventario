package com.ipn.mx.inventario.services.impl;

import com.ipn.mx.inventario.domain.entidades.*;
import com.ipn.mx.inventario.domain.repositorios.CategoriaRepository;
import com.ipn.mx.inventario.domain.repositorios.MovimientoRepository;
import com.ipn.mx.inventario.domain.repositorios.ProductoRepository;
import com.ipn.mx.inventario.domain.repositorios.ProveedorRepository;
import com.ipn.mx.inventario.dto.ProductoDTO;
import com.ipn.mx.inventario.services.ProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.AbstractFutureOrPresentInstantBasedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
@Transactional

public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    @Transactional
    public Producto crearProducto(ProductoDTO productoDTO) {
        Categoria categoria = categoriaRepository.findById(productoDTO.getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Proveedor proveedor = proveedorRepository.findById(productoDTO.getId_proveedor())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        Producto producto = Producto.builder()
                .nombre(productoDTO.getNombre())
                .descripcion(productoDTO.getDescripcion())
                .categoria(categoria)
                .proveedor(proveedor)
                .precioCompra(productoDTO.getPrecioCompra())
                .precioVenta(productoDTO.getPrecioVenta())
                .stock(productoDTO.getStock())
                .build();

        return productoRepository.save(producto);
    }
    @Override
    @Transactional
    public Optional<Producto> getProducto(Integer id) {
        return productoRepository.findById(id);
    }
    @Override
    @Transactional
    public Iterable<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
    @Override
    @Transactional
    public void deleteProducto(Integer id) {
        productoRepository.deleteById(id);
    }
    @Override
    @Transactional
    public Producto updateProducto(Integer id, ProductoDTO productoDTO) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));


            Categoria categoria = categoriaRepository.findById(productoDTO.getIdCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            productoExistente.setCategoria(categoria);



            Proveedor proveedor = proveedorRepository.findById(productoDTO.getId_proveedor())
                    .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
            productoExistente.setProveedor(proveedor);
        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setDescripcion(productoDTO.getDescripcion());
        productoExistente.setPrecioCompra(productoDTO.getPrecioCompra());
        productoExistente.setPrecioVenta(productoDTO.getPrecioVenta());
        productoExistente.setStock(productoDTO.getStock());

        // Guardar y retornar el producto actualizado
        return productoRepository.save(productoExistente);
    }

    @Override
    @Transactional
    public void actualizarStock(Integer productoId, Integer cantidad, TipoMovimiento tipo) {
        Optional<Producto> productoOpt = productoRepository.findById(productoId);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();

            if (tipo == TipoMovimiento.DEVOLUCION) {
                producto.setStock(producto.getStock() + cantidad);
            } else {
                if (producto.getStock() < cantidad) {
                    throw new RuntimeException("Stock insuficiente");
                }
                producto.setStock(producto.getStock() - cantidad);
            }

            productoRepository.save(producto);
            Movimiento movimiento = new Movimiento();
            movimiento.setProducto(producto);
            movimiento.setCantidad(cantidad);
            movimiento.setTipoMovimiento(tipo);
            movimiento.setFecha(LocalDateTime.now());
            movimientoRepository.save(movimiento);
        } else {
            throw new RuntimeException("Producto no encontrado");
        }
    }
}