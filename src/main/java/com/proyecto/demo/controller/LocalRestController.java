package com.proyecto.demo.controller;

import com.proyecto.demo.dto.LocalDto;
import com.proyecto.demo.dto.ProductoDto;
import com.proyecto.demo.model.Local;
import com.proyecto.demo.model.Producto;
import com.proyecto.demo.service.api.LocalServiceApi;
import com.proyecto.demo.service.api.ProductoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LocalRestController {

     @Autowired
    private LocalServiceApi localServiceApi;

     @Autowired
     private ProductoServiceApi productoServiceApi;

     @RequestMapping(method = RequestMethod.GET, value = "/locales")
    public ResponseEntity getLocales() {

         return new ResponseEntity<>(localServiceApi.getAll(), HttpStatus.OK);

     }

     @RequestMapping(method = RequestMethod.GET, value = "/local/id")
    public ResponseEntity get(@PathVariable Long id){

         Local local = localServiceApi.get(id);

         return new ResponseEntity<>(local, HttpStatus.OK);

     }

     @RequestMapping(method = RequestMethod.POST, value = "/addlocal")
    public ResponseEntity addLocal(@RequestBody LocalDto localNuevo){

         Local newLocal = localNuevo.parseLocal();

         return new ResponseEntity<>(localServiceApi.save(newLocal),HttpStatus.OK);


     }

}
