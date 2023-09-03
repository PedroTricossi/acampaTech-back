package com.ASPEL.camp.service;

import com.ASPEL.camp.model.AcampamentosCompletos;

import java.util.List;

public interface AcampamentosCompletosService {
    AcampamentosCompletos save(AcampamentosCompletos acampamentosCompletos);

    List<AcampamentosCompletos> findAcampamentosCompletosByCampistaId(Long campistaId);

    List<AcampamentosCompletos> findAcampamentosCompletosByAcampamentoId(Long acampamentoId);
}
