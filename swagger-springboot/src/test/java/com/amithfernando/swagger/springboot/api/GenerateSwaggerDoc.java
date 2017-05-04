/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amithfernando.swagger.springboot.api;

import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author amithfernando
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GenerateSwaggerDoc {

    @Test
    public void convertRemoteSwaggerToAsciiDoc() throws IOException {
        Swagger2MarkupConverter.from("http://localhost:8090/v2/api-docs").build().intoFolder("src/docs/asciidoc/generated");

        // Then validate that three AsciiDoc files have been created
        String[] files = new File("src/docs/asciidoc/generated").list();
        assertThat(files).hasSize(3).containsAll(Arrays.asList("definitions.adoc", "overview.adoc", "paths.adoc"));
    }

}
