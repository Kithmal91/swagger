/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service.impl;

import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.dao.ComposerDao;
import com.amithfernando.swagger.springboot.api.v1.model.Composer;
import com.amithfernando.swagger.springboot.api.v1.service.ComposerService;
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
public class ComposerServiceImpl implements ComposerService {

    @Autowired
    private ComposerDao composerDao;

    @Override
    public List<Composer> finaAllComposers() {
        List<Composer> composers = new ArrayList<>();
        Iterable<Composer> iterable = composerDao.findAll();
        for (Composer composer : iterable) {
            composers.add(composer);
        }
        return composers;
    }

    @Override
    public List<Composer> finaByStatus(GeneralStatus status) {
        List<Composer> composers = composerDao.findByStatus(status);
        return composers;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Composer save(Composer composer) {
        Composer save = composerDao.save(composer);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Composer update(Composer composer) {
        Composer save = composerDao.save(composer);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delet(Composer composer) {
        composer.setStatus(GeneralStatus.DELETED);
        Composer save = composerDao.save(composer);
    }

    @Override
    public Composer findById(Long id) {
        Composer findOne = composerDao.findOne(id);
        return findOne;
    }

}
