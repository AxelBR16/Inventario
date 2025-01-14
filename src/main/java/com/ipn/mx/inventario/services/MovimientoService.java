package com.ipn.mx.inventario.services;
import com.ipn.mx.inventario.domain.entidades.Movimiento;

import java.util.List;


public interface MovimientoService {
    List<Movimiento> getAllMovimientos();
}
