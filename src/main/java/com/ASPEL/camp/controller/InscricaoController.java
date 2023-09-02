package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.Inscricao;
import com.ASPEL.camp.service.impl.InscricaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/camp/inscricao")
@CrossOrigin
public class InscricaoController {
    @Autowired
    InscricaoServiceImpl inscricaoService;
    @PostMapping
    public ResponseEntity<Inscricao> saveInscricao(@RequestBody Inscricao inscricao){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.save(inscricao));
    }

    @GetMapping
    public ResponseEntity<List<Inscricao>> findAllIncricoes(){
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoService.findAll());
    }
}
