package com.ASPEL.camp.service;

import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.model.Campista;

import java.util.List;

public interface AcampamentoService {
    List<Acampamento> findAll();
    List<Acampamento> findAcampamentosOpen();
    List<Acampamento> findNextAcampamentos();
    Acampamento findAcampamentoById(Long id);
    Acampamento save(Acampamento acampamento);
    List<Acampamento> findAcampamentosInscritosByCampistaId(Long campistaId);
}
