package com.ar.webapp;

public class Usuario {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    private String fechaNacimiento;
    private String pais;

    public Usuario(){
        // constructor vacio */
    }

    public Usuario(Integer id, String nombre, String apelido, String email, String clave, String fechaNacimiento, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apelido;
        this.email = email;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apelido) {
        this.apellido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apelido=" + apellido + ", email=" + email + ", clave="
                + clave + ", fechaNacimiento=" + fechaNacimiento + ", pais=" + pais + "]";
    }

}
