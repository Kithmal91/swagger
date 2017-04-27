/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.resources;

import com.amithfernando.swagger.springboot.api.v1.model.Writer;
import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
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
 * @author amithfernando
 */
@RestController
public class WriterResource {

    private final Logger log = LoggerFactory.getLogger(WriterResource.class);

    @Autowired
    private WriterService writerService;

    @GetMapping("/writers")
    public List<Writer> getAllWriters() {
        List<Writer> writers = writerService.finaAllWriters();
        return writers;
    }

    @GetMapping("/writers/status/{status}")
    public List<Writer> getWritersByStatus(@PathVariable("status") String status) {
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Writer> writers = writerService.finaByStatus(generalStatus);
        return writers;
    }

    @GetMapping("/writers/{id}")
    public Writer getWritersById(@PathVariable Long id) {
        Writer writers = writerService.findById(id);
        return writers;
    }

    @PostMapping("/writers")
    public Writer saveWriter(@RequestBody Writer writer) {
        Writer savedWriter = writerService.save(writer);
        return savedWriter;
    }

    @PutMapping("/writers")
    public Writer updateWriter(@RequestBody Writer writer) {
        Writer savedWriter = writerService.update(writer);
        return savedWriter;
    }

    @DeleteMapping("/writers")
    public void deleteWriter(@RequestBody Writer writer) {
        writerService.delet(writer);
    }
}
