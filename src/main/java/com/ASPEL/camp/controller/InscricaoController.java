package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.FormularioInscricao;
import com.ASPEL.camp.service.impl.InscricaoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inscricao")
@CrossOrigin
public class InscricaoController {

    private final InscricaoServiceImpl inscricaoService;

    public InscricaoController(InscricaoServiceImpl inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    @PostMapping
    public ResponseEntity<FormularioInscricao> saveInscricao(@RequestBody FormularioInscricao formularioInscricao){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.save(formularioInscricao));
    }

    @GetMapping
    public ResponseEntity<List<FormularioInscricao>> findAllIncricoes(){
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoService.findAll());
    }

    @GetMapping("/campista/{id}")
    public ResponseEntity<FormularioInscricao> findInscricaoByCampistaId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoService.findInscricaoByCampistaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormularioInscricao> updateInscricao(@PathVariable Long id, @RequestBody FormularioInscricao formularioInscricao){
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoService.updateInscricao(id, formularioInscricao));
    }

    @DeleteMapping("/acampamento/{id}")
    public ResponseEntity<?> deleteInscricao(@PathVariable Long id){
        inscricaoService.deleteInscricaoByAcampamentoId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
