package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.*;
import com.ASPEL.camp.service.impl.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/camp/acampamento")
@CrossOrigin
public class AcampamentoController {
    private final AcampamentoServiceImpl acampamentoService;

    public AcampamentoController(AcampamentoServiceImpl acampamentoService) {
        this.acampamentoService = acampamentoService;
    }

    @PostMapping
    public ResponseEntity<Acampamento> saveAcampamento(@RequestBody Acampamento acampamento){
        return ResponseEntity.status(HttpStatus.CREATED).body(acampamentoService.save(acampamento));
    }

    @GetMapping
    public ResponseEntity<List<Acampamento>> findAllAcampamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acampamento> findAcampamentosById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findAcampamentoById(id));
    }

    @GetMapping("/campista/{id}")
    public ResponseEntity<List<Acampamento>> findAllAcampamentos(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findAcampamentosInscritosByCampistaId(id));
    }

    @GetMapping("/proximosAcampamentos")
    public ResponseEntity<List<Acampamento>> findProximosAcampamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findNextAcampamentos());
    }

    @GetMapping("/inscricoesAbertas")
    public ResponseEntity<List<Acampamento>> findIncricoesAbertas(){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findAcampamentosOpen());
    }
}
