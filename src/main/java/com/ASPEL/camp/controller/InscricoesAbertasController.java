package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.model.InscricoesAbertas;
import com.ASPEL.camp.service.impl.InscricoesAbertasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/camp/inscricoesAbertas")
@CrossOrigin
public class InscricoesAbertasController {
    @Autowired
    InscricoesAbertasServiceImpl inscricoesAbertasService;
    @PostMapping
    public ResponseEntity<InscricoesAbertas> saveAcampamentoTrabalhado(@RequestBody InscricoesAbertas InscricoesAbertas){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricoesAbertasService.save(InscricoesAbertas));
    }

}
