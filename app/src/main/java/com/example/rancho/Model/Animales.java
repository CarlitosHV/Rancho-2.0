package com.example.rancho.Model;

public class Animales {

    private String Nombre;
    private String Descripcion;
    private double Precio;
    private boolean vendido;
    private String propietario;
    private String comprador;
    private String id;
    private String idPropie;
    private String idCompra;

    public Animales() {
    }

    public Animales(String nombre, String descripcion, double precio, String propietario, String idPropie) {
        Nombre = nombre;
        Descripcion = descripcion;
        Precio = precio;
        this.propietario = propietario;
        this.idPropie = idPropie;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdPropie() {
        return idPropie;
    }

    public void setIdPropie(String idPropie) {
        this.idPropie = idPropie;
    }
}
