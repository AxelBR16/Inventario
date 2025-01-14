package com.ipn.mx.inventario.domain.repositorios;

import com.ipn.mx.inventario.domain.entidades.OrdenCompra;
import com.ipn.mx.inventario.domain.entidades.Proveedor;
import org.springframework.data.repository.CrudRepository;


import java.math.BigDecimal;
import java.time.LocalDate;

public interface OrdenCompraRepository extends CrudRepository<OrdenCompra, Integer> {
    Iterable<OrdenCompra> findByProveedor(Proveedor proveedor);
    Iterable<OrdenCompra> findByFechaEntregaBetween(LocalDate inicio, LocalDate fin);
    Iterable<OrdenCompra> findByTotalGreaterThan(BigDecimal total);
}
