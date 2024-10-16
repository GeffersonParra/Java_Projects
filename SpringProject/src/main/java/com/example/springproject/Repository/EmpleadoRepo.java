package com.example.springproject.Repository;
import com.example.springproject.Entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepo extends CrudRepository<Empleado, Long>{
    //
}
