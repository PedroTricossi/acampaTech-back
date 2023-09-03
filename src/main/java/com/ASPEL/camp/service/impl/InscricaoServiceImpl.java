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
    @Transactional
    public Inscricao save(Inscricao inscricao) {
        Inscricao inscrito = inscricaoRepository.findByCampistaId(inscricao.getCampistaId());

        if(inscrito == null)
            return inscricaoRepository.save(inscricao);

        return inscrito;
    }

    @Override
    @Transactional(readOnly = true)
    public Inscricao findInscricaoByCampistaId(Long id) {
        return inscricaoRepository.findByCampistaId(id);
    }

    @Override
    @Transactional
    public Inscricao updateInscricao(Long id, Inscricao inscricao) {
        return inscricaoRepository.findById(id).map( inscrito -> {
            System.out.println("Entrou");
            inscrito.setCampistaId(inscricao.getCampistaId());
            inscrito.setAcampamentoId(inscricao.getAcampamentoId());
            inscrito.setEquipePreferencia(inscricao.getEquipePreferencia());
            inscrito.setEquipeEscolhida(inscricao.getEquipeEscolhida());
            inscrito.setFamiliaresAcampamento(inscricao.getFamiliaresAcampamento());
            return inscricaoRepository.save(inscrito);
        }).orElseGet( () -> {
            System.out.println("Nao deveria estar aqui");
            return inscricaoRepository.save(inscricao);
        });
    }

    @Override
    @Transactional
    public void deleteInscricaoByAcampamentoId(Long acampamentoId) {
        inscricaoRepository.deleteByAcampamentoId(acampamentoId);
    }
}
