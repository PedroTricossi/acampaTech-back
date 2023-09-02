package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.Inscritos;
import com.ASPEL.camp.service.impl.InscritosServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/camp/inscritos")
@CrossOrigin
public class inscritosController {

    private final InscritosServiceImpl inscritosService;

    public inscritosController(InscritosServiceImpl inscritosService) {
        this.inscritosService = inscritosService;
    }

    @PostMapping
    public ResponseEntity<Inscritos> saveInscritos(@RequestBody Inscritos inscritos){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscritosService.save(inscritos));
    }

}
