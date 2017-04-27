/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.resources;

import com.amithfernando.swagger.springboot.api.v1.model.Category;
import com.amithfernando.swagger.springboot.api.v1.model.Composer;
import com.amithfernando.swagger.springboot.api.v1.model.Singer;
import com.amithfernando.swagger.springboot.api.v1.model.Song;
import com.amithfernando.swagger.springboot.api.v1.model.Writer;
import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.service.CategoryService;
import com.amithfernando.swagger.springboot.api.v1.service.ComposerService;
import com.amithfernando.swagger.springboot.api.v1.service.SingerService;
import com.amithfernando.swagger.springboot.api.v1.service.SongService;
import com.amithfernando.swagger.springboot.api.v1.service.WriterService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amith
 */
@RestController
public class SongResource {

    private final Logger log = LoggerFactory.getLogger(SongResource.class);

    @Autowired
    private SongService songService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private WriterService writerService;
    @Autowired
    private ComposerService composerService;
    @Autowired
    private SingerService singerService;

    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        List<Song> songs = songService.finaAllSongs();
        return songs;
    }

    @GetMapping("/songs/status/{status}")
    public List<Song> getSongsByStatus(@PathVariable("status") String status) {
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Song> songs = songService.finaByStatus(generalStatus);
        return songs;
    }

    @GetMapping("/songs/{id}")
    public Song getSongsById(@PathVariable Long id) {
        Song songs = songService.findById(id);
        return songs;
    }

    @PostMapping("/songs")
    public Song saveSong(@RequestBody Song song) {
        Song savedSong = songService.save(song);
        return savedSong;
    }

    @PutMapping("/songs")
    public Song updateSong(@RequestBody Song song) {
        Song savedSong = songService.update(song);
        return savedSong;
    }

    @DeleteMapping("/songs")
    public void deleteSong(@RequestBody Song song) {
        songService.delete(song);
    }

    @GetMapping("/categorys/{id}/songs")
    public List<Song> getSongsByCategorysId(@PathVariable Long id) {
        Category categorys = categoryService.findById(id);
        List<Song> songs = songService.findByCategory(categorys);
        return songs;
    }

    @GetMapping("/categorys/{id}/songs/status/{status}")
    public List<Song> getSongsByCategorysId(@PathVariable Long id, @PathVariable("status") String status) {
        Category categorys = categoryService.findById(id);
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Song> songs = songService.findByCategoryAndStatus(categorys, generalStatus);
        return songs;
    }

    @GetMapping("/writers/{id}/songs")
    public List<Song> getSongsByWritersId(@PathVariable Long id) {
        Writer writer = writerService.findById(id);
        List<Song> songs = songService.findByWriter(writer);
        return songs;
    }

    @GetMapping("/writers/{id}/songs/status/{status}")
    public List<Song> getSongsByWritersId(@PathVariable Long id, @PathVariable("status") String status) {
        Writer writer = writerService.findById(id);
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Song> songs = songService.findByWriterAndStatus(writer, generalStatus);
        return songs;
    }
    
    @GetMapping("/composers/{id}/songs")
    public List<Song> getSongsByComposerId(@PathVariable Long id) {
        Composer composer = composerService.findById(id);
        List<Song> songs = songService.findByComposer(composer);
        return songs;
    }

    @GetMapping("/composers/{id}/songs/status/{status}")
    public List<Song> getSongsByComposerId(@PathVariable Long id, @PathVariable("status") String status) {
        Composer composer = composerService.findById(id);
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Song> songs = songService.findByComposerAndStatus(composer, generalStatus);
        return songs;
    }

     @GetMapping("/singers/{id}/songs")
    public List<Song> getSongsBySingerId(@PathVariable Long id) {
        Singer singer = singerService.findById(id);
        List<Song> songs = songService.findBySinger(singer);
        return songs;
    }

    @GetMapping("/singers/{id}/songs/status/{status}")
    public List<Song> getSongsBySingerId(@PathVariable Long id, @PathVariable("status") String status) {
        Singer singer = singerService.findById(id);
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Song> songs = songService.findBySingerAndStatus(singer, generalStatus);
        return songs;
    }


}
