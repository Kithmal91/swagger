/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service.impl;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.dao.WriterDao;
import com.amithfernando.swagger.springboot.api.v1.model.Writer;
import com.amithfernando.swagger.springboot.api.v1.service.WriterService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amithfernando
 */
@Service
public class WriterServiceImpl implements WriterService {

    @Autowired
    private WriterDao writerDao;

    @Override
    public List<Writer> finaAllWriters() {
        List<Writer> writers = new ArrayList<>();
        Iterable<Writer> iterable = writerDao.findAll();
        for (Writer writer : iterable) {
            writers.add(writer);
        }
        return writers;
    }

    @Override
    public List<Writer> finaByStatus(GeneralStatus status) {
        List<Writer> writers = writerDao.findByStatus(status);
        return writers;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Writer save(Writer writer) {
        Writer save = writerDao.save(writer);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Writer update(Writer writer) {
        Writer save = writerDao.save(writer);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delet(Writer writer) {
        writer.setStatus(GeneralStatus.DELETED);
        Writer save = writerDao.save(writer);
    }

    @Override
    public Writer findById(Long id) {
        Writer findOne = writerDao.findOne(id);
        return findOne;
    }

}
