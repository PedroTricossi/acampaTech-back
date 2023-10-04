package com.ASPEL.camp.service;

import com.ASPEL.camp.model.FormularioInscricao;

import java.util.List;

public interface InscricaoService {
    FormularioInscricao findInscricaoByCampistaAndAcampamentoId(Long campistaId, Long acampamentoId);

    List<FormularioInscricao> findAll();

    FormularioInscricao save(FormularioInscricao formularioInscricao);

    FormularioInscricao findInscricaoByCampistaId(Long id);

    FormularioInscricao updateInscricao(Long id, FormularioInscricao formularioInscricao);

    void deleteInscricaoByAcampamentoId(Long acampamentoId);
}
