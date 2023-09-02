package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.AcampamentoTrabalhado;
import com.ASPEL.camp.service.impl.AcampamentoTrabalhadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/camp/acampamentoTrabalhado")
@CrossOrigin
public class AcampamentoTrabalhadoController {

    private final AcampamentoTrabalhadoServiceImpl acampamentoTrabalhadoService;

    public AcampamentoTrabalhadoController(AcampamentoTrabalhadoServiceImpl acampamentoTrabalhadoService) {
        this.acampamentoTrabalhadoService = acampamentoTrabalhadoService;
    }

    @PostMapping
    public ResponseEntity<AcampamentoTrabalhado> saveAcampamentoTrabalhado(@RequestBody AcampamentoTrabalhado acampamento){
        return ResponseEntity.status(HttpStatus.CREATED).body(acampamentoTrabalhadoService.save(acampamento));
    }

    @GetMapping
    public ResponseEntity<List<AcampamentoTrabalhado>> findAllAcampamentoTrabalhado(){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoTrabalhadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AcampamentoTrabalhado>> findAcampamentoTrabalhadoByCampistaId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoTrabalhadoService.findByCampistaId(id));
    }

}
