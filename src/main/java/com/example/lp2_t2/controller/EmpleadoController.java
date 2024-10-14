package com.example.lp2_t2.controller;

import com.example.lp2_t2.model.Empleado;
import com.example.lp2_t2.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listAll(Model model) {
        List<Empleado> empleados = empleadoService.findAll();
        model.addAttribute("empleados", empleados);
        return "empleados/list";
    }

    @GetMapping("/{dni}")
    public String getById(@PathVariable String dni, Model model) {
        Optional<Empleado> empleado = empleadoService.findById(dni);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "empleados/detail";
        } else {
            model.addAttribute("error", "Empleado no encontrado");
            return "empleados/error";
        }
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/form";
    }

    @PostMapping
    public String save(@ModelAttribute Empleado empleado) {
        empleadoService.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/edit/{dni}")
    public String editForm(@PathVariable String dni, Model model) {
        Optional<Empleado> empleado = empleadoService.findById(dni);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            return "empleados/form";
        } else {
            model.addAttribute("error", "Empleado no encontrado");
            return "empleados/error";
        }
    }

    @PostMapping("/update/{dni}")
    public String update(@PathVariable String dni, @ModelAttribute Empleado empleado) {
        empleado.setDni_empleado(dni);
        empleadoService.save(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/delete/{dni}")
    public String delete(@PathVariable String dni) {
        empleadoService.deleteById(dni);
        return "redirect:/empleados";
    }
}