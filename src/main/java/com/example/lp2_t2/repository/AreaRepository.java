package com.example.lp2_t2.repository;

import com.example.lp2_t2.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    // Puedes agregar métodos personalizados si es necesario
}