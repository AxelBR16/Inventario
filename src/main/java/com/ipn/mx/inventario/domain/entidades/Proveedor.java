package com.ipn.mx.inventario.domain.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Proveedores")

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private int id_proveedor;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @NotNull(message = "El teléfono no puede ser nulo")
    @Column(name = "telefono", length = 10, nullable = false)
    private String telefono;

    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "Debe proporcionar un email válido")
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Producto> productos;
}
