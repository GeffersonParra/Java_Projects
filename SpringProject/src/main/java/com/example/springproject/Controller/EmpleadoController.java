package com.example.springproject.Controller;

import com.example.springproject.Entity.Empleado;
import com.example.springproject.Entity.Rol;
import com.example.springproject.Repository.EmpleadoRepo;
import com.example.springproject.ServiceInterface.EmpleadoServiceInterface;
import com.example.springproject.ServiceInterface.RolServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoServiceInterface empleadoService;
    @Autowired
    private RolServiceInterface rolService;

    @GetMapping("/list")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        model.addAttribute("empleados", empleados);
        return "ListaEmpleados";
    }

    @GetMapping("/create")
    public String crearEmpleados(Model model) {
        List<Rol> roles = rolService.obtenerTodosLosRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("empleado", new Empleado());
        return "CrearEmpleado";
    }

    @PostMapping("/save")
    public String guardarEmpleados(Empleado empleado, @RequestParam("rol_id") int rolId) {
        Rol rol = rolService.obtenerRolPorId(rolId);
        empleado.setRol(rol);
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados/list";
    }

    @PostMapping("/delete/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados/list";
    }

    @GetMapping("/show/{id}")
    public String mostrarEmpleado(@PathVariable("id") Long id, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        return "MostrarEmpleado";
    }

    @GetMapping("/edit/{id}")
    public String editarEmpleados(@PathVariable("id")Long id, Model model) {
        List<Rol> roles = rolService.obtenerTodosLosRoles();
        model.addAttribute("roles", roles);
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        return "EditarEmpleado";
    }

    @PostMapping("/update/{id}")
    public String actualizarEmpleados(@PathVariable("id") Long id, @ModelAttribute("empleado") Empleado empleado) {
        Empleado empleadoExistente = empleadoService.obtenerEmpleadoPorId(id);
        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellido(empleado.getApellido());
        empleadoExistente.setEdad(empleado.getEdad());
        empleadoExistente.setTelefono(empleado.getTelefono());
        empleadoExistente.setEmail(empleado.getEmail());
        empleadoExistente.setDireccion(empleado.getDireccion());
        empleadoExistente.setSexo(empleado.getSexo());
        if (empleado.getRol() != null) {
            empleadoExistente.setRol(new Rol());
            empleadoExistente.getRol().setId(empleado.getRol().getId());
        }
        empleadoService.guardarEmpleado(empleadoExistente);
        return "redirect:/empleados/show/{id}";
    }


}
