package com.ipn.mx.inventario.services;

import com.ipn.mx.inventario.domain.entidades.OrdenCompra;

import java.util.List;

public interface OrdenCompraService {
    OrdenCompra saveMovimiento(OrdenCompra ordenCompra);
    List<OrdenCompra> listarTodas();
}
