package com.ASPEL.camp.service;

import com.ASPEL.camp.model.Campista;

import java.util.List;

public interface CampistaService {
    List<Campista> findAll();
    Campista findById(long id);
    Campista save(Campista campista);
    List<Campista> findCampistasInscritosByAcampamentoId(Long acampamentoId);
}
