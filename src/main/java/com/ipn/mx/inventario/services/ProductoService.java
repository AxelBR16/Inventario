package com.ipn.mx.inventario.services;
import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodos();
    Producto obtenerPorId(int id);
    Producto createProducto(ProductoDTO productoDTO);
    Producto actualizarProducto(int id, Producto producto);
    void eliminarProducto(int id);
}
