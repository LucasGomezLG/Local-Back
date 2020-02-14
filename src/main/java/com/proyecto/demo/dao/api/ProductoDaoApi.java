package com.proyecto.demo.dao.api;

import com.proyecto.demo.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDaoApi extends CrudRepository<Producto, Long> {
}
