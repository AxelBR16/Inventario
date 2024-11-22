package com.ipn.mx.inventario.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    private String descripcion;

    @NotNull(message = "La categoría no puede ser nula")
    private int idCategoria;

    @NotNull(message = "El precio de compra no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio de compra debe ser mayor o igual a 0")
    private BigDecimal precioCompra;

    @NotNull(message = "El precio de venta no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio de venta debe ser mayor o igual a 0")
    private BigDecimal precioVenta;

    @NotNull(message = "El stock no puede ser nulo")
    private int stock;

    @NotNull(message = "El ID del proveedor no puede ser nulo")
    private int id_proveedor;
}