package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.repository.AcampamentoRepository;
import com.ASPEL.camp.service.AcampamentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcampamentoServiceImpl implements AcampamentoService {

    private final AcampamentoRepository acampamentoRepository;

    public AcampamentoServiceImpl(AcampamentoRepository acampamentoRepository) {
        this.acampamentoRepository = acampamentoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Acampamento> findAll() {
        return acampamentoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Acampamento> findAcampamentosOpen() {
        return acampamentoRepository.findAcampamentoOpen();
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
    public Acampamento save(Acampamento acampamento) {
        return acampamentoRepository.save(acampamento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Acampamento> findAcampamentosInscritosByCampistaId(Long campistaId) {
        return acampamentoRepository.findAcampamentoIncritosByCampistaId(campistaId);
    }
}
