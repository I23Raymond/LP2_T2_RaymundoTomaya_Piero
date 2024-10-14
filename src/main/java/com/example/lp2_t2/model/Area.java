package com.example.lp2_t2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int area_id;

    @Column(name = "nombre_area", nullable = false, length = 45)
    private String nombreArea;

    // Constructor por defecto
    public Area() {}

    // Constructor con parámetros
    public Area(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    // Getters y Setters
    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    @Override
    public String toString() {
        return "Area{" +
                "area_id=" + area_id +
                ", nombreArea='" + nombreArea + '\'' +
                '}';
    }
}