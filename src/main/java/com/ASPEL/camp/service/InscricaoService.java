package com.ASPEL.camp.service;

import com.ASPEL.camp.model.Inscricao;

import java.util.List;

public interface InscricaoService {
    Inscricao findInscricaoByCampistaAndAcampamentoId(Long campistaId, Long acampamentoId);

    List<Inscricao> findAll();

    Inscricao save(Inscricao inscricao);

    Inscricao findInscricaoByCampistaId(Long id);

    Inscricao updateInscricao(Long id, Inscricao inscricao);

    void deleteInscricaoByAcampamentoId(Long acampamentoId);
}
