package com.ipn.mx.inventario.domain.repositorios;


import com.ipn.mx.inventario.domain.entidades.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {
}
