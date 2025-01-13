package com.ipn.mx.inventario.services.impl;

import com.ipn.mx.inventario.domain.entidades.Movimiento;
import com.ipn.mx.inventario.domain.entidades.OrdenCompra;
import com.ipn.mx.inventario.domain.repositorios.OrdenCompraRepository;
import com.ipn.mx.inventario.services.OrdenCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private final OrdenCompraRepository ordenCompraRepository;

    public OrdenCompra saveMovimiento(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    @Override
    public List<OrdenCompra> listarTodas() {
        return (List<OrdenCompra>) ordenCompraRepository.findAll();
    }
}
