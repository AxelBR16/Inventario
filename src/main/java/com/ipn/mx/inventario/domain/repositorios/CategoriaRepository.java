package com.ipn.mx.inventario.domain.repositorios;

import com.ipn.mx.inventario.domain.entidades.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    Iterable<Categoria> findByNombreContaining(String nombre);
}
