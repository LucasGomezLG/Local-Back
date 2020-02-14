package com.proyecto.demo.dto;

import com.proyecto.demo.model.Local;
import com.proyecto.demo.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class LocalDto {

    private String nombre;
    private String direccion;
    private String descripcion;
    private String categoria;
    private List<Producto> productos = new ArrayList<>();

    public LocalDto(){

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Local parseLocal(){

        return new Local(this.nombre, this.direccion, this.descripcion, this.productos, this.categoria);
    }

}
