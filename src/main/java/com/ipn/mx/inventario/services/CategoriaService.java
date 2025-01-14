package com.ipn.mx.inventario.services;

import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.Categoria;


import java.util.List;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    void eliminarCategoria(int id);
    List<Categoria> listarCategorias();
}
