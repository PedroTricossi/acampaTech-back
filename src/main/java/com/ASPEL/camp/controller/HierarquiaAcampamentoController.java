package com.ASPEL.camp.controller;

import com.ASPEL.camp.model.HierarquiaAcampamento;
import com.ASPEL.camp.service.impl.HierarquiaAcampamentoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/camp/hierarquia")
@CrossOrigin
public class HierarquiaAcampamentoController {
    private final HierarquiaAcampamentoServiceImpl hierarquiaAcampamentoService;

    public HierarquiaAcampamentoController(HierarquiaAcampamentoServiceImpl hierarquiaAcampamentoService) {
        this.hierarquiaAcampamentoService = hierarquiaAcampamentoService;
    }

    @GetMapping("campista/{campistaId}/acampamento/{acampamentoId}")
    public ResponseEntity<Integer> canWorkInCampByCampId(@PathVariable Long campistaId,@PathVariable Long acampamentoId){
        return ResponseEntity.status(HttpStatus.OK).body(hierarquiaAcampamentoService.verificaHierarquiaAcampamento(campistaId, acampamentoId));
    }

    @PostMapping
    public ResponseEntity<HierarquiaAcampamento> canWorkInCampByCampId(@RequestBody HierarquiaAcampamento hierarquiaAcampamento){
        return ResponseEntity.status(HttpStatus.OK).body(hierarquiaAcampamentoService.save(hierarquiaAcampamento));
    }

}
