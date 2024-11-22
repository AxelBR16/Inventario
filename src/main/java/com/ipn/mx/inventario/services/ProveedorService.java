package com.ipn.mx.inventario.services;

import com.ipn.mx.inventario.domain.entidades.Proveedor;

import java.util.List;

public interface ProveedorService {
    List<Proveedor> obtenerTodos();
    Proveedor obtenerPorId(int id);
    Proveedor crearProveedor(Proveedor proveedor);
    Proveedor actualizarProveedor(int id, Proveedor proveedor);
    void eliminarProveedor(int id);
}