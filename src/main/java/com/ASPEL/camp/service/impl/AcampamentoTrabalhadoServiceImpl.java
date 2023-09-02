package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.AcampamentoTrabalhado;
import com.ASPEL.camp.repository.AcampamentosTrabalhadoRepository;
import com.ASPEL.camp.service.AcampamentoTrabalhadoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcampamentoTrabalhadoServiceImpl implements AcampamentoTrabalhadoService {

    private final AcampamentosTrabalhadoRepository acampamentosTrabalhadoRepository;

    public AcampamentoTrabalhadoServiceImpl(AcampamentosTrabalhadoRepository acampamentosTrabalhadoRepository) {
        this.acampamentosTrabalhadoRepository = acampamentosTrabalhadoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AcampamentoTrabalhado> findByCampistaId(Long campistaId) {
        return acampamentosTrabalhadoRepository.findAcampamentoTrabalhadoByCampistaId(campistaId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AcampamentoTrabalhado> findByAcampamentoId(Long acampamentoId) {
        return acampamentosTrabalhadoRepository.findAcampamentoTrabalhadoByAcampamentoId(acampamentoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AcampamentoTrabalhado> findAll() {
        return acampamentosTrabalhadoRepository.findAll();
    }

    @Override
    public AcampamentoTrabalhado save(AcampamentoTrabalhado acampamentoTrabalhado) {
        return acampamentosTrabalhadoRepository.save(acampamentoTrabalhado);
    }
}
