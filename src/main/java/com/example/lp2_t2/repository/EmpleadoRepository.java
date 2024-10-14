package com.example.lp2_t2.repository;

import com.example.lp2_t2.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    // Puedes agregar métodos personalizados si es necesario
}