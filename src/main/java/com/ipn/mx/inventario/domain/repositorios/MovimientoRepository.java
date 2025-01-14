package com.ipn.mx.inventario.domain.repositorios;


import com.ipn.mx.inventario.domain.entidades.Movimiento;
import com.ipn.mx.inventario.domain.entidades.Producto;
import com.ipn.mx.inventario.domain.entidades.TipoMovimiento;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface MovimientoRepository extends CrudRepository<Movimiento, Integer> {
    Iterable<Movimiento> findByProducto(Producto producto);
    Iterable<Movimiento> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}
