package com.ipn.mx.inventario.domain.repositorios;

import com.ipn.mx.inventario.domain.entidades.Proveedor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProveedorRepository extends CrudRepository<Proveedor, Integer> {
    Iterable<Proveedor> findByNombreContaining(String nombre);
    Optional<Proveedor> findByEmail(String email);
}
