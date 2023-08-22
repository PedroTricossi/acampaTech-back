package com.ASPEL.camp.service;

import com.ASPEL.camp.model.AcampamentoTrabalhado;

import java.util.List;

public interface AcampamentoTrabalhadoService {
    List<AcampamentoTrabalhado> findByCampistaId(Long campistaId) ;
    List<AcampamentoTrabalhado> findByAcampamentoId(Long acampamentoId);

    List<AcampamentoTrabalhado> findAll();
    AcampamentoTrabalhado save(AcampamentoTrabalhado acampamentoTrabalhado);
}
