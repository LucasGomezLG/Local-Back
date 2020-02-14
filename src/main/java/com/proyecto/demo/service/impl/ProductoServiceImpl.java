package com.proyecto.demo.service.impl;

import com.proyecto.demo.commons.GenericServiceImp;
import com.proyecto.demo.dao.api.ProductoDaoApi;
import com.proyecto.demo.model.Producto;
import com.proyecto.demo.service.api.ProductoServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImp <Producto, Long> implements ProductoServiceApi {

    @Autowired
    private ProductoDaoApi productoDaoApi;

    @Override
    public CrudRepository<Producto, Long> getDao() {
        return productoDaoApi;
    }

}
