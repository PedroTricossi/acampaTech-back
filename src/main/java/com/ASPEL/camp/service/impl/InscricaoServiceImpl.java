package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Inscricao;
import com.ASPEL.camp.repository.InscricaoRepository;
import com.ASPEL.camp.service.InscricaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InscricaoServiceImpl implements InscricaoService {
    private final InscricaoRepository inscricaoRepository;

    public InscricaoServiceImpl(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Inscricao findInscricaoByCampistaAndAcampamentoId(Long acampamentoId, Long campistaId) {
        return inscricaoRepository.findByAcampamentoIdAndCampistaId(acampamentoId, campistaId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    @Override
    public Inscricao save(Inscricao inscricao) {
        Inscricao inscrito = inscricaoRepository.findByCampistaId(inscricao.getCampistaId());

        if(inscrito == null)
            return inscricaoRepository.save(inscricao);

        return inscrito;
    }

    @Override
    public Inscricao findInscricaoByCampistaId(Long id) {
        return inscricaoRepository.findByCampistaId(id);
    }
}
