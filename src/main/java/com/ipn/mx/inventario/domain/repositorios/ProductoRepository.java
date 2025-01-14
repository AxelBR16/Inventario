package com.ipn.mx.inventario.domain.repositorios;

import com.ipn.mx.inventario.domain.entidades.Categoria;
import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.Proveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    Iterable<Producto> findByCategoria(Categoria categoria);
    Iterable<Producto> findByProveedor(Proveedor proveedor);
    Iterable<Producto> findByStockLessThan(Integer stockMinimo);
    Iterable<Producto> findByNombreContaining(String nombre);
}
