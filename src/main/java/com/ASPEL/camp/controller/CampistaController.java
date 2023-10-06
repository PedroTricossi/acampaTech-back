package com.ASPEL.camp.controller;

import com.ASPEL.camp.dto.CampistaDto;
import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.service.impl.CampistaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/campista")
@CrossOrigin(origins = "*")
public class CampistaController {

    private final CampistaServiceImpl campistaService;

    public CampistaController(CampistaServiceImpl campistaService) {
        this.campistaService = campistaService;
    }

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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Campista> savePerson(@RequestBody CampistaDto campista){
        return ResponseEntity.status(HttpStatus.CREATED).body(campistaService.save(campista));
    }
}
