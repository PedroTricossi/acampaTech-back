package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.dto.AcampamentoDto;
import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.repository.AcampamentoRepository;
import com.ASPEL.camp.repository.CampistaRepository;
import com.ASPEL.camp.service.AcampamentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class AcampamentoServiceImpl implements AcampamentoService {

    private final AcampamentoRepository acampamentoRepository;
    private final CampistaRepository campistaRepository;

    public AcampamentoServiceImpl(AcampamentoRepository acampamentoRepository, CampistaRepository campistaRepository) {
        this.acampamentoRepository = acampamentoRepository;
        this.campistaRepository = campistaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Acampamento> findAll() {
        return acampamentoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Acampamento> findInscricoesAbertas() {
            List<Acampamento> acampamentos = acampamentoRepository.findAll();
            List<Acampamento> inscricoesAbertas = new LinkedList<>();

            for(Acampamento acampamento:acampamentos){
                if(acampamento.getInscricoesAbertas()){
                    inscricoesAbertas.add(acampamento);
                }
            }

            return inscricoesAbertas;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Acampamento> findNextAcampamentos() {
        return acampamentoRepository.findAcampamentoByCloseToNow();
    }

    @Override
    @Transactional(readOnly = true)
    public Acampamento findAcampamentoById(Long id) {
        return acampamentoRepository.findAcampamentoById(id);
    }

    @Override
    public Acampamento save(AcampamentoDto acampamento) {
        Acampamento novoAcampamento = new Acampamento();
        Set<Acampamento> acampamentoSet = new HashSet<>();

        novoAcampamento.setNome(acampamento.getNome());
        novoAcampamento.setEdicao(acampamento.getEdicao());
        novoAcampamento.setTema(acampamento.getTema());
        novoAcampamento.setDataFim(acampamento.getDataFim());
        novoAcampamento.setDataInicio(acampamento.getDataInicio());
        novoAcampamento.setInscricoesAbertas(acampamento.getInscricoesAbertas());

        for(String acampa:acampamento.getAcampamentosPodeTrabalhar()){
            Acampamento podeTrabalhar = acampamentoRepository.findAcampamentoByNome(acampa)
                    .orElseThrow(() -> new RuntimeException("Error: Acampamento not found"));

            acampamentoSet.add(podeTrabalhar);
        }

        novoAcampamento.setAcampamentosPodeTrabalhar(acampamentoSet);

        return acampamentoRepository.save(novoAcampamento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Acampamento> findAcampamentosInscritosByCampistaId(Long campistaId) {
        return acampamentoRepository.findAcampamentoIncritosByCampistaId(campistaId);
    }

    @Override
    public Boolean findCampistaPermission(Long id, Long acampamentoId) {
        Acampamento acampamento = acampamentoRepository.findAcampamentoById(acampamentoId);
        Campista campista = campistaRepository.findCampistaById(id);

        for(Acampamento acampa: acampamento.getAcampamentosPodeTrabalhar()){
            for (Acampamento campiAcampa : campista.getAcampamentosRealizados()){
                if(acampa.getId().equals(campiAcampa.getId())){
                    return true;
                }
            }
        }

        return false;
    }
}
