package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.*;
import com.ASPEL.camp.service.InscritosService;
import com.ASPEL.camp.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/camp")
@CrossOrigin
public class CampController {
    @Autowired
    CampistaServiceImpl personService;
    @Autowired
    AcampamentoServiceImpl acampamentoService;
    @Autowired
    AcampamentoTrabalhadoServiceImpl acampamentoTrabalhadoService;
    @Autowired
    InscricoesAbertasServiceImpl inscricoesAbertasService;
    @Autowired
    InscritosServiceImpl inscritosService;
    @Autowired
    InscricaoServiceImpl inscricaoService;

    @GetMapping("/campista")
    public ResponseEntity<List<Campista>> findAllCampistas(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }

    @GetMapping("/campista/{id}")
    public ResponseEntity<Campista> findCampistaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.findById(id));
    }

    @GetMapping("/campista/acampamento/{id}")
    public ResponseEntity<List<Campista>> findCampistasInscritosByAcampamentoId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.findCampistasInscritosByAcampamentoId(id));
    }

    @PostMapping
    public ResponseEntity<Campista> savePerson(@RequestBody Campista campista){
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(campista));
    }

    @GetMapping("/acampamento")
    public ResponseEntity<List<Acampamento>> findAllAcampamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findAll());
    }

    @GetMapping("/acampamento/{id}")
    public ResponseEntity<Acampamento> findAcampamentosById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findAcampamentoById(id));
    }

    @GetMapping("/acampamento/campista/{id}")
    public ResponseEntity<List<Acampamento>> findAllAcampamentos(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findAcampamentosInscritosByCampistaId(id));
    }

    @PostMapping("/acampamento")
    public ResponseEntity<Acampamento> saveAcampamento(@RequestBody Acampamento acampamento){
        return ResponseEntity.status(HttpStatus.CREATED).body(acampamentoService.save(acampamento));
    }

    @PostMapping("/acampamentoTrabalhado")
    public ResponseEntity<AcampamentoTrabalhado> saveAcampamentoTrabalhado(@RequestBody AcampamentoTrabalhado acampamento){
        return ResponseEntity.status(HttpStatus.CREATED).body(acampamentoTrabalhadoService.save(acampamento));
    }

    @GetMapping("/acampamentoTrabalhado")
    public ResponseEntity<List<AcampamentoTrabalhado>> findAllAcampamentoTrabalhado(){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoTrabalhadoService.findAll());
    }

    @GetMapping("/acampamentoTrabalhado/{id}")
    public ResponseEntity<List<AcampamentoTrabalhado>> findAcampamentoTrabalhadoByCampistaId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoTrabalhadoService.findByCampistaId(id));
    }

    @PostMapping("/incricoesAbertas")
    public ResponseEntity<InscricoesAbertas> saveAcampamentoTrabalhado(@RequestBody InscricoesAbertas InscricoesAbertas){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricoesAbertasService.save(InscricoesAbertas));
    }

    @GetMapping("/incricoesAbertas")
    public ResponseEntity<List<Acampamento>> findIncricoesAbertas(){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findAcampamentosOpen());
    }

    @GetMapping("/proximosAcampamentos")
    public ResponseEntity<List<Acampamento>> findProximosAcampamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(acampamentoService.findNextAcampamentos());
    }

    @PostMapping("/inscritos")
    public ResponseEntity<Inscritos> saveInscritos(@RequestBody Inscritos inscritos){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscritosService.save(inscritos));
    }

    @PostMapping("/inscricao")
    public ResponseEntity<Inscricao> saveInscricao(@RequestBody Inscricao inscricao){
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoService.save(inscricao));
    }

    @GetMapping("/inscricao")
    public ResponseEntity<List<Inscricao>> findAllIncricoes(){
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoService.findAll());
    }
}
