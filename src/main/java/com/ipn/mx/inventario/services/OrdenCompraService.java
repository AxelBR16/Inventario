package com.ipn.mx.inventario.services;

import com.ipn.mx.inventario.domain.entidades.OrdenCompra;
import com.ipn.mx.inventario.dto.OrdenCompraDTO;

import java.util.List;

public interface OrdenCompraService {
    OrdenCompra crearOrdenCompra(OrdenCompraDTO ordenCompraDTO);
    List<OrdenCompra> listarTodas();
}
