package com.example.lp2_t2.service;

import com.example.lp2_t2.model.Area;
import com.example.lp2_t2.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;

    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    public Optional<Area> findById(int id) {
        return areaRepository.findById(id);
    }

    public Area save(Area area) {
        return areaRepository.save(area);
    }

    public void deleteById(int id) {
        areaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return areaRepository.existsById(id);
    }
}