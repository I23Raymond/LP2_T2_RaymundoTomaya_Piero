package com.example.lp2_t2.service;

import com.example.lp2_t2.model.Empleado;
import com.example.lp2_t2.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> findById(String dni) {
        return empleadoRepository.findById(dni);
    }

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void deleteById(String dni) {
        empleadoRepository.deleteById(dni);
    }

    public boolean existsById(String dni) {
        return empleadoRepository.existsById(dni);
    }
}