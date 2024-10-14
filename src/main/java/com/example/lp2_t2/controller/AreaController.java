package com.example.lp2_t2.controller;

import com.example.lp2_t2.model.Area;
import com.example.lp2_t2.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping
    public String listAll(Model model) {
        List<Area> areas = areaService.findAll();
        model.addAttribute("areas", areas);
        return "areas/list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        Optional<Area> area = areaService.findById(id);
        if (area != null) {
            model.addAttribute("area", area);
            return "areas/detail";
        } else {
            model.addAttribute("error", "Área no encontrada");
            return "areas/error";
        }
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("area", new Area());
        return "areas/form";
    }

    @PostMapping
    public String save(@ModelAttribute Area area) {
        areaService.save(area);
        return "redirect:/areas";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Optional<Area> area = areaService.findById(id);
        if (area != null) {
            model.addAttribute("area", area);
            return "areas/form";
        } else {
            model.addAttribute("error", "Área no encontrada");
            return "areas/error";
        }
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute Area area) {
        area.setArea_id(id);
        areaService.save(area);
        return "redirect:/areas";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        areaService.deleteById(id);
        return "redirect:/areas";
    }
}