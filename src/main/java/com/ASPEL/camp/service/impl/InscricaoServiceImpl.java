package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.FormularioInscricao;
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
    public FormularioInscricao findInscricaoByCampistaAndAcampamentoId(Long acampamentoId, Long campistaId) {
        return inscricaoRepository.findByAcampamentoIdAndCampistaId(acampamentoId, campistaId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FormularioInscricao> findAll() {
        return inscricaoRepository.findAll();
    }

    @Override
    @Transactional
    public FormularioInscricao save(FormularioInscricao formularioInscricao) {
        FormularioInscricao inscrito = inscricaoRepository.findByCampistaId(formularioInscricao.getCampistaId());

        if(inscrito == null)
            return inscricaoRepository.save(formularioInscricao);

        return inscrito;
    }

    @Override
    @Transactional(readOnly = true)
    public FormularioInscricao findInscricaoByCampistaId(Long id) {
        return inscricaoRepository.findByCampistaId(id);
    }

    @Override
    @Transactional
    public FormularioInscricao updateInscricao(Long id, FormularioInscricao formularioInscricao) {
        return inscricaoRepository.findById(id).map( inscrito -> {
            System.out.println("Entrou");
            inscrito.setCampistaId(formularioInscricao.getCampistaId());
            inscrito.setAcampamentoId(formularioInscricao.getAcampamentoId());
            inscrito.setEquipePreferencia(formularioInscricao.getEquipePreferencia());
            inscrito.setEquipeEscolhida(formularioInscricao.getEquipeEscolhida());
            inscrito.setFamiliaresAcampamento(formularioInscricao.getFamiliaresAcampamento());
            return inscricaoRepository.save(inscrito);
        }).orElseGet( () -> {
            System.out.println("Nao deveria estar aqui");
            return inscricaoRepository.save(formularioInscricao);
        });
    }

    @Override
    @Transactional
    public void deleteInscricaoByAcampamentoId(Long acampamentoId) {
        inscricaoRepository.deleteByAcampamentoId(acampamentoId);
    }
}
