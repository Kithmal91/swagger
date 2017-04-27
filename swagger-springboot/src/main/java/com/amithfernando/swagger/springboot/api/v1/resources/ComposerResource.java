/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.resources;

import com.amithfernando.swagger.springboot.api.v1.model.Composer;
import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import com.amithfernando.swagger.springboot.api.v1.service.ComposerService;
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
public class ComposerResource {

    private final Logger log = LoggerFactory.getLogger(ComposerResource.class);

    @Autowired
    private ComposerService composerService;

    @GetMapping("/composers")
    public List<Composer> getAllComposers() {
        List<Composer> composers = composerService.finaAllComposers();
        return composers;
    }

    @GetMapping("/composers/status/{status}")
    public List<Composer> getComposersByStatus(@PathVariable("status") String status) {
        GeneralStatus generalStatus = GeneralStatus.valueOf(status);
        List<Composer> composers = composerService.finaByStatus(generalStatus);
        return composers;
    }

    @GetMapping("/composers/{id}")
    public Composer getComposersById(@PathVariable Long id) {
        Composer composers = composerService.findById(id);
        return composers;
    }

    @PostMapping("/composers")
    public Composer saveComposer(@RequestBody Composer composer) {
        Composer savedComposer = composerService.save(composer);
        return savedComposer;
    }

    @PutMapping("/composers")
    public Composer updateComposer(@RequestBody Composer composer) {
        Composer savedComposer = composerService.update(composer);
        return savedComposer;
    }

    @DeleteMapping("/composers")
    public void deleteComposer(@RequestBody Composer composer) {
        composerService.delet(composer);
    }
}
