/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api.v1.dao;

import com.amithfernando.swagger.springboot.api.v1.model.Composer;
import com.amithfernando.swagger.springboot.api.v1.model.enums.GeneralStatus;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amithfernando
 */
@Repository
public interface ComposerDao extends CrudRepository<Composer, Long> {

    public List<Composer> findByStatus(GeneralStatus status);

}
