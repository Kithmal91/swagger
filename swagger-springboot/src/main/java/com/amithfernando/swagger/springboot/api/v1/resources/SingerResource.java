/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.resources;

import com.amithfernando.swagger.springboot.api.v1.model.Singer;
import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.service.SingerService;
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
 * @author amithfernando
 */
@RestController
public class SingerResource {

    private final Logger log = LoggerFactory.getLogger(SingerResource.class);

    @Autowired
    private SingerService singerService;

    @GetMapping("/singers")
    public List<Singer> getAllSingers() {
        List<Singer> singers = singerService.finaAllSingers();
        return singers;
    }

    @GetMapping("/singers/status/{status}")
    public List<Singer> getSingersByStatus(@PathVariable("status") String status) {
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Singer> singers = singerService.finaByStatus(generalStatus);
        return singers;
    }

    @GetMapping("/singers/{id}")
    public Singer getSingersById(@PathVariable Long id) {
        Singer singers = singerService.findById(id);
        return singers;
    }

    @PostMapping("/singers")
    public Singer saveSinger(@RequestBody Singer singer) {
        Singer savedSinger = singerService.save(singer);
        return savedSinger;
    }

    @PutMapping("/singers")
    public Singer updateSinger(@RequestBody Singer singer) {
        Singer savedSinger = singerService.update(singer);
        return savedSinger;
    }

    @DeleteMapping("/singers")
    public void deleteSinger(@RequestBody Singer singer) {
        singerService.delet(singer);
    }
}
