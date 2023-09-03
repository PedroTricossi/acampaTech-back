package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.AcampamentosCompletos;
import com.ASPEL.camp.repository.AcampamentosCompletosRepository;
import com.ASPEL.camp.service.AcampamentosCompletosService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcampamentosCompletosServiceImpl implements AcampamentosCompletosService {
    private final AcampamentosCompletosRepository acampamentosCompletosRepository;

    public AcampamentosCompletosServiceImpl(AcampamentosCompletosRepository acampamentosCompletosRepository) {
        this.acampamentosCompletosRepository = acampamentosCompletosRepository;
    }

    @Override
    @Transactional
    public AcampamentosCompletos save(AcampamentosCompletos acampamentosCompletos) {
        return acampamentosCompletosRepository.save(acampamentosCompletos);
    }

    @Override
    public List<AcampamentosCompletos> findAcampamentosCompletosByCampistaId(Long campistaId) {
        return acampamentosCompletosRepository.findAcampamentosCompletosByCampistaId(campistaId);
    }

    @Override
    public List<AcampamentosCompletos> findAcampamentosCompletosByAcampamentoId(Long acampamentoId) {
        return acampamentosCompletosRepository.findAcampamentosCompletosByAcampamentoId(acampamentoId);
    }
}
