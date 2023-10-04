package com.ASPEL.camp.service;

import com.ASPEL.camp.dto.CampistaDto;
import com.ASPEL.camp.model.Campista;

import java.util.List;
import java.util.Optional;

public interface CampistaService {
    List<Campista> findAll();
    Campista findById(long id);
    Campista save(CampistaDto campista);
    List<Campista> findCampistasInscritosByAcampamentoId(Long acampamentoId);

    Optional<Campista> findCampistaByNome(String nome);
}
