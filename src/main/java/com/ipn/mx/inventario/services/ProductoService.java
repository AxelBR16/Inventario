package com.ipn.mx.inventario.services;
import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.TipoMovimiento;
import com.ipn.mx.inventario.dto.ProductoDTO;


import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto crearProducto(ProductoDTO productoDTO);
    Optional<Producto> getProducto(Integer id);
    Iterable<Producto> getAllProductos();
    void deleteProducto(Integer id);
    Producto updateProducto(Integer id, ProductoDTO productoDTO);
    void actualizarStock(Integer productoId, Integer cantidad, TipoMovimiento tipo);
}
