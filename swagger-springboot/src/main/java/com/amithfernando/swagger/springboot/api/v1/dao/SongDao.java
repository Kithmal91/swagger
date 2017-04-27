/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.dao;

import com.amithfernando.swagger.springboot.api.v1.model.Category;
import com.amithfernando.swagger.springboot.api.v1.model.Composer;
import com.amithfernando.swagger.springboot.api.v1.model.Singer;
import com.amithfernando.swagger.springboot.api.v1.model.Song;
import com.amithfernando.swagger.springboot.api.v1.model.Writer;
import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amithfernando
 */
@Repository
public interface SongDao extends CrudRepository<Song, Long> {

    public List<Song> findByStatus(GeneralStatus status);

    public List<Song> findByCategory(Category category);

    public List<Song> findByCategoryAndStatus(Category category, GeneralStatus generalStatus);

    public List<Song> findByWriter(Writer writer);

    public List<Song> findByWriterAndStatus(Writer writer, GeneralStatus generalStatus);

    public List<Song> findByComposer(Composer composer);

    public List<Song> findByComposerAndStatus(Composer composer, GeneralStatus generalStatus);

    public List<Song> findBySinger(Singer singer);

    public List<Song> findBySingerAndStatus(Singer singer, GeneralStatus generalStatus);

}
