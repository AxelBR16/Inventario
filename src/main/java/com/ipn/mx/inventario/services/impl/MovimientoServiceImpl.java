package com.ipn.mx.inventario.services.impl;

import com.ipn.mx.inventario.domain.entidades.Movimiento;
import com.ipn.mx.inventario.domain.repositorios.MovimientoRepository;
import com.ipn.mx.inventario.services.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;

    public Movimiento saveMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public List<Movimiento> getAllMovimientos() {
        return (List<Movimiento>) movimientoRepository.findAll();
    }


}
