package com.ipn.mx.inventario.services.impl;

import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.Proveedor;
import com.ipn.mx.inventario.domain.repositorios.ProductoRepository;
import com.ipn.mx.inventario.domain.repositorios.ProveedorRepository;
import com.ipn.mx.inventario.dto.ProductoDTO;
import com.ipn.mx.inventario.services.ProductoService;
import com.ipn.mx.inventario.services.ProveedorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> obtenerTodos() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto obtenerPorId(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto createProducto(ProductoDTO dto) {
        Proveedor proveedor = proveedorRepository.findById(dto.getId_proveedor())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Proveedor no encontrado con ID: " + dto.getId_proveedor()));

        Producto producto = Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .idCategoria(dto.getIdCategoria())
                .precioCompra(dto.getPrecioCompra())
                .precioVenta(dto.getPrecioVenta())
                .stock(dto.getStock())
                .proveedor(proveedor)
                .build();

        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public Producto actualizarProducto(int id, Producto producto) {
        Producto productoExistente = obtenerPorId(id);

        if (productoExistente == null) {
            throw new IllegalArgumentException("Producto no encontrado con el ID: " + id);
        }

        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecioCompra(producto.getPrecioCompra());
        productoExistente.setPrecioVenta(producto.getPrecioVenta());
        productoExistente.setStock(producto.getStock());

        // Validar si el proveedor asociado existe
        if (producto.getProveedor() == null || producto.getProveedor().getId_proveedor() == 0) {
            throw new IllegalArgumentException("El ID del proveedor no puede ser nulo o 0.");
        }

        Proveedor proveedor = proveedorService.obtenerPorId(producto.getProveedor().getId_proveedor());
        if (proveedor == null) {
            throw new IllegalArgumentException("Proveedor no encontrado con el ID: " + producto.getProveedor().getId_proveedor());
        }

        // Asociar solo el proveedor por ID
        productoExistente.setProveedor(proveedor);

        return productoRepository.save(productoExistente);
    }

    @Override
    @Transactional
    public void eliminarProducto(int id) {
        Producto producto = obtenerPorId(id);

        if (producto == null) {
            throw new IllegalArgumentException("Producto no encontrado con el ID: " + id);
        }

        productoRepository.delete(producto);
    }
}
