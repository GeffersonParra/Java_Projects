package com.example.springproject.Service;

import com.example.springproject.Entity.Empleado;
import com.example.springproject.Entity.Rol;
import com.example.springproject.Repository.RolRepo;
import com.example.springproject.ServiceInterface.RolServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class RolService implements RolServiceInterface {
    @Autowired
    private RolRepo rolRepo;

    @Override
    public List<Rol> obtenerTodosLosRoles() {
        return (List<Rol>) rolRepo.findAll();
    }

    @Override
    public Rol obtenerRolPorId(int id) {
        return rolRepo.findById(id).orElse(null);
    }

    @Override
    public Rol guardarRol(Rol rol) {
        return null;
    }

    @Override
    public void eliminarRol(Long id) {

    }
}
