package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.repository.CampistaRepository;
import com.ASPEL.camp.service.CampistaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampistaServiceImpl implements CampistaService {
    private final CampistaRepository campistaRepository;

    public CampistaServiceImpl(CampistaRepository campistaRepository) {
        this.campistaRepository = campistaRepository;
    }

    @Override
    public Campista save(Campista campista) {
        return campistaRepository.save(campista);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Campista> findCampistasInscritosByAcampamentoId(Long acampamentoId) {
        return campistaRepository.findCampistasIncritosByAcampamentoId(acampamentoId);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Campista> findAll() {
        return campistaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Campista findById(long id) {
        return campistaRepository.findCampistaById(id);
    }
}
