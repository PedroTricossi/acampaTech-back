package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.InscricoesAbertas;
import com.ASPEL.camp.service.impl.InscricoesAbertasServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/camp/inscricoesAbertas")
@CrossOrigin
public class InscricoesAbertasController {

    private final InscricoesAbertasServiceImpl inscricoesAbertasService;

    public InscricoesAbertasController(InscricoesAbertasServiceImpl inscricoesAbertasService) {
        this.inscricoesAbertasService = inscricoesAbertasService;
    }

    @PostMapping
    public ResponseEntity<InscricoesAbertas> saveAcampamentoTrabalhado(@RequestBody InscricoesAbertas InscricoesAbertas){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricoesAbertasService.save(InscricoesAbertas));
    }

}
