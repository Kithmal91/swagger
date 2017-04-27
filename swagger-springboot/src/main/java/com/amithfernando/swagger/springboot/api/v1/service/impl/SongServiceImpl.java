/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.service.impl;

import com.amithfernando.swagger.springboot.api.v1.dao.SongDao;
import com.amithfernando.swagger.springboot.api.v1.model.Category;
import com.amithfernando.swagger.springboot.api.v1.model.Composer;
import com.amithfernando.swagger.springboot.api.v1.model.Singer;
import com.amithfernando.swagger.springboot.api.v1.model.Song;
import com.amithfernando.swagger.springboot.api.v1.model.Writer;
import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.service.SongService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongDao songDao;

    @Override
    public List<Song> finaAllSongs() {
        List<Song> categorys = new ArrayList<>();
        Iterable<Song> iterable = songDao.findAll();
        for (Song category : iterable) {
            categorys.add(category);
        }
        return categorys;
    }

    @Override
    public List<Song> finaByStatus(GeneralStatus status) {
        List<Song> categorys = songDao.findByStatus(status);
        return categorys;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Song save(Song song) {
        Song save = songDao.save(song);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Song update(Song song) {
        Song save = songDao.save(song);
        return save;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delete(Song song) {
        song.setStatus(GeneralStatus.DELETED);
        Song save = songDao.save(song);
    }

    @Override
    public Song findById(Long id) {
        Song findOne = songDao.findOne(id);
        return findOne;
    }

    @Override
    public List<Song> findByCategory(Category category) {
        List<Song> songs = songDao.findByCategory(category);
        return songs;
    }

    @Override
    public List<Song> findByCategoryAndStatus(Category category, GeneralStatus generalStatus) {
        List<Song> songs = songDao.findByCategoryAndStatus(category, generalStatus);
        return songs;
    }

    @Override
    public List<Song> findByWriter(Writer writer) {
        List<Song> songs = songDao.findByWriter(writer);
        return songs;
    }

    @Override
    public List<Song> findByWriterAndStatus(Writer writer, GeneralStatus generalStatus) {
        List<Song> songs = songDao.findByWriterAndStatus(writer, generalStatus);
        return songs;
    }

    @Override
    public List<Song> findByComposer(Composer composer) {
        List<Song> songs = songDao.findByComposer(composer);
        return songs;
    }

    @Override
    public List<Song> findByComposerAndStatus(Composer composer, GeneralStatus generalStatus) {
        List<Song> songs = songDao.findByComposerAndStatus(composer, generalStatus);
        return songs;
    }

    @Override
    public List<Song> findBySinger(Singer singer) {
        List<Song> songs = songDao.findBySinger(singer);
        return songs;
    }

    @Override
    public List<Song> findBySingerAndStatus(Singer singer, GeneralStatus generalStatus) {
        List<Song> songs = songDao.findBySingerAndStatus(singer, generalStatus);
        return songs;
    }

}
