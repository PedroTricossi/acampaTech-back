package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.repository.AcampamentoRepository;
import com.ASPEL.camp.service.AcampamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcampamentoServiceImpl implements AcampamentoService {
    @Autowired
    AcampamentoRepository acampamentoRepository;
    @Override
    public List<Acampamento> findAll() {
        return acampamentoRepository.findAll();
    }

    @Override
    public List<Acampamento> findAcampamentosOpen() {
        return acampamentoRepository.findAcampamentoOpen();
    }

    @Override
    public List<Acampamento> findNextAcampamentos() {
        return acampamentoRepository.findAcampamentoByCloseToNow();
    }

    @Override
    public Acampamento findAcampamentoById(Long id) {
        return acampamentoRepository.findAcampamentoById(id);
    }

    @Override
    public Acampamento save(Acampamento acampamento) {
        return acampamentoRepository.save(acampamento);
    }

    @Override
    public List<Acampamento> findAcampamentosInscritosByCampistaId(Long campistaId) {
        return acampamentoRepository.findAcampamentoIncritosByCampistaId(campistaId);
    }
}
