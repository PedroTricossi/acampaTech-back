package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.AcampamentosCompletos;
import com.ASPEL.camp.service.impl.AcampamentosCompletosServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/camp/acampamentoCompleto")
@CrossOrigin
public class AcampamentosCompletosController {
    private final AcampamentosCompletosServiceImpl acampamentoCompletoService;

    public AcampamentosCompletosController(AcampamentosCompletosServiceImpl acampamentoCompletoService) {
        this.acampamentoCompletoService = acampamentoCompletoService;
    }

    @PostMapping
    public ResponseEntity<AcampamentosCompletos> saveAcampamentosCompletos(@RequestBody AcampamentosCompletos acampamentosCompletos){
        return ResponseEntity.status(HttpStatus.CREATED).body(acampamentoCompletoService.save(acampamentosCompletos));
    }

    @GetMapping("/campista/{id}")
    public ResponseEntity<List<AcampamentosCompletos>> findAcampamentosCompletosByCampistaId(@PathVariable Long campistaId){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoCompletoService.findAcampamentosCompletosByCampistaId(campistaId));
    }

    @GetMapping("/acampamento/{id}")
    public ResponseEntity<List<AcampamentosCompletos>> findAcampamentosCompletosByAcampamentoId(@PathVariable Long acampamentoId){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoCompletoService.findAcampamentosCompletosByAcampamentoId(acampamentoId));
    }


}
