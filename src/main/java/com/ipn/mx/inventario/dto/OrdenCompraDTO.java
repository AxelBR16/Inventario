package com.ipn.mx.inventario.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrdenCompraDTO {
    private int idProveedor;
    private int idProducto;
    private int cantidad;
    private double total;
    private LocalDate fechaEntrega;
}
