package com.ipn.mx.inventario.domain.repositorios;

import com.ipn.mx.inventario.domain.entidades.Categorias;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categorias, Integer> {
}
