package com.ipn.mx.inventario.services;

import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.Categorias;


import java.util.List;

public interface CategoriaService {
    Categorias crearCategoria(Categorias categoria);
    void eliminarCategoria(int id);
    List<Producto> listarProductosPorCategoria(int idCategoria);
}
