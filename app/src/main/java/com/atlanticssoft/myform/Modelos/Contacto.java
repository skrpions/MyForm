package com.atlanticssoft.myform.Modelos;

import java.util.Date;

public class Contacto
{
    private String nombre;
    private Date nacimiento;
    private String telefono;
    private String correo;
    private String descripcion;

    public Contacto(String nombre, Date nacimiento, String telefono, String correo, String descripcion) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
