package com.example.model.pendientes;

public class BeanUsuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String puesto;

    public BeanUsuario() {
    }

    public BeanUsuario(int id, String nombre, String apellidos, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
