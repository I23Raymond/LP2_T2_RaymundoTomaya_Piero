package com.example.lp2_t2.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_empleado")
public class Empleado {
    @Id
    @Column(name = "dni_empleado", nullable = false, length = 8)
    private String dni_empleado;

    @Column(name = "nombre_empleado", nullable = false, length = 45)
    private String nombreEmpleado;

    @Column(name = "apellido_empleado", nullable = false, length = 45)
    private String apellidoEmpleado;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "direccion", length = 45)
    private String direccion;

    @Column(name = "correo", length = 45)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    // Constructor por defecto
    public Empleado() {}

    // Constructor con parámetros
    public Empleado(String dni_empleado, String nombreEmpleado, String apellidoEmpleado, Date fechaNacimiento, String direccion, String correo, Area area) {
        this.dni_empleado = dni_empleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.area = area;
    }

    // Getters y Setters
    public String getDni_empleado() {
        return dni_empleado;
    }

    public void setDni_empleado(String dni_empleado) {
        this.dni_empleado = dni_empleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni_empleado='" + dni_empleado + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", apellidoEmpleado='" + apellidoEmpleado + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", area=" + area +
                '}';
    }
}