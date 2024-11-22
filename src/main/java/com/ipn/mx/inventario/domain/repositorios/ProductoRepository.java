package com.ipn.mx.inventario.domain.repositorios;

import com.ipn.mx.inventario.domain.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    @Query("from Proveedor")
    public List<Producto> listarProductos();
}
