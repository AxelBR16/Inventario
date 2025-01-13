package com.ipn.mx.inventario.dto;

import lombok.Data;

@Data
public class MovimientoDTO {
    private int productoId;
    private String tipoMovimiento;
    private int cantidad;
}

