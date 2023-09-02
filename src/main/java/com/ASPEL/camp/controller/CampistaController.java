package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.service.impl.CampistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/camp/campista")
@CrossOrigin
public class CampistaController {
    @Autowired
    CampistaServiceImpl campistaService;
    @GetMapping
    public ResponseEntity<List<Campista>> findAllCampistas(){
        return ResponseEntity.status(HttpStatus.OK).body(campistaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campista> findCampistaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(campistaService.findById(id));
    }

    @GetMapping("/acampamento/{id}")
    public ResponseEntity<List<Campista>> findCampistasInscritosByAcampamentoId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(campistaService.findCampistasInscritosByAcampamentoId(id));
    }

    @PostMapping
    public ResponseEntity<Campista> savePerson(@RequestBody Campista campista){
        return ResponseEntity.status(HttpStatus.CREATED).body(campistaService.save(campista));
    }
}
