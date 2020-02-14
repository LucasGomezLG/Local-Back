package com.proyecto.demo.dto;

import com.proyecto.demo.model.Local;
import com.proyecto.demo.model.Producto;

public class ProductoDto {

private String marca;
private String descripcion;
private int precio;
private int cantidad = 0;
private long id_local;

public ProductoDto(){
}

    public long getId_local() {
        return id_local;
    }

    public void setId_local(long id_local) {
        this.id_local = id_local;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public Producto parseProducto() {

        return new Producto(this.marca, this.descripcion, this.precio, this.cantidad);

    }

}
