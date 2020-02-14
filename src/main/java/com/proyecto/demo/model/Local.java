package com.proyecto.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String direccion;

    @Column
    private String descripcion;

    @Column
    private String categoria;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();

    public Local() {

    }

    public Local(String nombre, String direccion, String descripcion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
    }

    public Local(String nombre, String direccion, String descripcion, List<Producto> productos ){
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.productos = productos;
    }

    public Local(String nombre, String direccion, String descripcion, List<Producto> productos , String categoria){
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.productos = productos;
        this.categoria = categoria;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }

}
