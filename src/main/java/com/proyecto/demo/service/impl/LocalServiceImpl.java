package com.proyecto.demo.service.impl;

import com.proyecto.demo.commons.GenericServiceImp;
import com.proyecto.demo.dao.api.LocalDaoApi;
import com.proyecto.demo.model.Local;
import com.proyecto.demo.service.api.LocalServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class LocalServiceImpl extends GenericServiceImp<Local, Long> implements LocalServiceApi {

    @Autowired
    private LocalDaoApi localDaoApi;

    @Override
    public CrudRepository<Local, Long> getDao() {
        return localDaoApi;
    }
}
