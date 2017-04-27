/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service.impl;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.dao.SingerDao;
import com.amithfernando.swagger.springboot.api.v1.model.Singer;
import com.amithfernando.swagger.springboot.api.v1.service.SingerService;
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
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerDao singerDao;

    @Override
    public List<Singer> finaAllSingers() {
        List<Singer> singers = new ArrayList<>();
        Iterable<Singer> iterable = singerDao.findAll();
        for (Singer singer : iterable) {
            singers.add(singer);
        }
        return singers;
    }

    @Override
    public List<Singer> finaByStatus(GeneralStatus status) {
        List<Singer> singers = singerDao.findByStatus(status);
        return singers;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Singer save(Singer singer) {
        Singer save = singerDao.save(singer);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Singer update(Singer singer) {
        Singer save = singerDao.save(singer);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delet(Singer singer) {
        singer.setStatus(GeneralStatus.DELETED);
        Singer save = singerDao.save(singer);
    }

    @Override
    public Singer findById(Long id) {
        Singer findOne = singerDao.findOne(id);
        return findOne;
    }

}
