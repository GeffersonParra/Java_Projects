package com.example.springproject.ServiceInterface;
import java.util.List;
import com.example.springproject.Entity.Empleado;

public interface EmpleadoServiceInterface {
    List<Empleado> obtenerTodosLosEmpleados();
    Empleado obtenerEmpleadoPorId(Long id);
    Empleado guardarEmpleado(Empleado empleado);
    void eliminarEmpleado(Long id);
}
