package com.ipn.mx.inventario.domain.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Ordenes_Compra")

public class OrdenCompra{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;


    private int cantidad;
    private double precioUnitario;
    private double total;
    private LocalDate fechaEntrega;
}
