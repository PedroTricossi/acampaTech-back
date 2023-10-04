package com.ASPEL.camp.service;

import com.ASPEL.camp.dto.AcampamentoDto;
import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.model.Campista;

import java.util.List;

public interface AcampamentoService {
    List<Acampamento> findAll();

    List<Acampamento> findInscricoesAbertas();
    List<Acampamento> findNextAcampamentos();
    Acampamento findAcampamentoById(Long id);
    Acampamento save(AcampamentoDto acampamento);
    List<Acampamento> findAcampamentosInscritosByCampistaId(Long campistaId);

    Boolean findCampistaPermission(Long id, Long acampamentoId);
}
