package com.example.springproject.Service;

import com.example.springproject.Entity.Empleado;
import com.example.springproject.Repository.EmpleadoRepo;
import com.example.springproject.ServiceInterface.EmpleadoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.List;
@Service
public class EmpleadoService implements EmpleadoServiceInterface {
    @Autowired
    private EmpleadoRepo empleadoRepo;
    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        return (List<Empleado>) empleadoRepo.findAll();
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepo.findById(id).get();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepo.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoRepo.deleteById(id);
    }
}
