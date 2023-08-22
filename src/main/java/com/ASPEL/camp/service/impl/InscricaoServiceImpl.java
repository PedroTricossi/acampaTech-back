package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Inscricao;
import com.ASPEL.camp.repository.InscricaoRepository;
import com.ASPEL.camp.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoServiceImpl implements InscricaoService {
    @Autowired
    InscricaoRepository inscricaoRepository;
    @Override
    public Inscricao findInscricaoByCampistaAndAcampamentoId(Long acampamentoId, Long campistaId) {
        return inscricaoRepository.findByAcampamentoIdAndCampistaId(acampamentoId, campistaId);
    }

    @Override
    public List<Inscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    @Override
    public Inscricao save(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }
}
