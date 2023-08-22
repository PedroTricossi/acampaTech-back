package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.AcampamentoTrabalhado;
import com.ASPEL.camp.repository.AcampamentosTrabalhadoRepository;
import com.ASPEL.camp.service.AcampamentoTrabalhadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcampamentoTrabalhadoServiceImpl implements AcampamentoTrabalhadoService {
    @Autowired
    AcampamentosTrabalhadoRepository acampamentosTrabalhadoRepository;
    @Override
    public List<AcampamentoTrabalhado> findByCampistaId(Long campistaId) {
        return acampamentosTrabalhadoRepository.findAcampamentoTrabalhadoByCampistaId(campistaId);
    }

    @Override
    public List<AcampamentoTrabalhado> findByAcampamentoId(Long acampamentoId) {
        return acampamentosTrabalhadoRepository.findAcampamentoTrabalhadoByAcampamentoId(acampamentoId);
    }

    @Override
    public List<AcampamentoTrabalhado> findAll() {
        return acampamentosTrabalhadoRepository.findAll();
    }

    @Override
    public AcampamentoTrabalhado save(AcampamentoTrabalhado acampamentoTrabalhado) {
        return acampamentosTrabalhadoRepository.save(acampamentoTrabalhado);
    }
}
