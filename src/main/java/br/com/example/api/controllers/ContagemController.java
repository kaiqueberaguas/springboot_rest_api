package br.com.example.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.annotation.Counted;
import io.swagger.annotations.Api;

@Api(tags = "Api de contagem")
@RestController
@RequestMapping("/api/v1/contagem")
public class ContagemController {

    private static int contador = 0;

    @Timed(value = "api_contagem")
    @Counted(recordFailuresOnly = false, value = "Teste")
    @GetMapping
    public ResponseEntity<Integer> get() {
        return new ResponseEntity<Integer>(contador++, HttpStatus.OK);
    }

}