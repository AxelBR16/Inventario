package com.ipn.mx.inventario.services.impl;

import com.ipn.mx.inventario.domain.entidades.Proveedor;
import com.ipn.mx.inventario.domain.repositorios.ProveedorRepository;
import com.ipn.mx.inventario.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository dao;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> obtenerTodos() {
        return (List<Proveedor>) dao.findAll();
    }

    @Override
    @Transactional
    public Proveedor obtenerPorId(int id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + id));
    }

    @Override
    @Transactional
    public Proveedor crearProveedor(Proveedor proveedor) {
        return dao.save(proveedor);
    }

    @Override
    @Transactional
    public Proveedor actualizarProveedor(int id, Proveedor proveedor) {
        Proveedor proveedorExistente = obtenerPorId(id);
        proveedorExistente.setNombre(proveedor.getNombre());
        proveedorExistente.setTelefono(proveedor.getTelefono());
        proveedorExistente.setEmail(proveedor.getEmail());
        return dao.save(proveedorExistente);
    }

    @Override
    @Transactional
    public void eliminarProveedor(int id) {
        Proveedor proveedor = obtenerPorId(id);
        dao.delete(proveedor);
    }

}
