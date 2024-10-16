package com.example.springproject.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String email;
    private String telefono;
    private String direccion;
}
