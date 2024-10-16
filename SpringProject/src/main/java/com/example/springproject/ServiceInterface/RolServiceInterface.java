package com.example.springproject.ServiceInterface;
import com.example.springproject.Entity.Empleado;
import com.example.springproject.Entity.Rol;

import java.util.List;

public interface RolServiceInterface {
    List<Rol> obtenerTodosLosRoles();
    Rol obtenerRolPorId(int id);
    Rol guardarRol(Rol rol);
    void eliminarRol(Long id);
}
