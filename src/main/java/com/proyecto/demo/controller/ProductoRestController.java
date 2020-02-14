package com.proyecto.demo.controller;

import com.proyecto.demo.dto.ProductoDto;
import com.proyecto.demo.model.Local;
import com.proyecto.demo.model.Producto;
import com.proyecto.demo.service.api.LocalServiceApi;
import com.proyecto.demo.service.api.ProductoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProductoRestController {

    @Autowired
    private LocalServiceApi localServiceApi;

    @Autowired
    private ProductoServiceApi productoServiceApi;

    @RequestMapping(method = RequestMethod.GET, value ="/productos")
    public ResponseEntity getProductos() {

        return new ResponseEntity<>(productoServiceApi.getAll(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/producto/{id}")
    public ResponseEntity get(@PathVariable Long id ){

        Producto producto = productoServiceApi.get(id);

        return new ResponseEntity <>( producto , HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/producto/{id}"  )
    public ResponseEntity deleteProducto(@PathVariable Long id) {

        productoServiceApi.delete(id);

        return new ResponseEntity <> (" DELETE " + id ,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value ="/addProducto")
    public ResponseEntity addProducto(@RequestBody ProductoDto productoNuevo) {

        Local local = localServiceApi.get(productoNuevo.getId_local());
        Producto newProducto = productoNuevo.parseProducto();
        newProducto.setLocal(local);
        local.agregarProducto(newProducto);

        return new ResponseEntity<>(productoServiceApi.save(newProducto),HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET , value = "/productosById")
    public ResponseEntity getProdById(@RequestParam HashMap<String,String> param){

        long localId;

        localId = Long.parseLong(param.get("id"));

        Local local = this.localServiceApi.get(localId);

        return new ResponseEntity<>(local.getProductos(), HttpStatus.OK);

    }


}
