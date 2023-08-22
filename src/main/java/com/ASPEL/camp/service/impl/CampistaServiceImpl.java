package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.repository.CampistaRepository;
import com.ASPEL.camp.service.CampistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampistaServiceImpl implements CampistaService {
    @Autowired
    private CampistaRepository campistaRepository;

    @Override
    public Campista save(Campista campista) {
        return campistaRepository.save(campista);
    }

    @Override
    public List<Campista> findCampistasInscritosByAcampamentoId(Long acampamentoId) {
        return campistaRepository.findCampistasIncritosByAcampamentoId(acampamentoId);
    }


    @Override
    public List<Campista> findAll() {
        return campistaRepository.findAll();
    }

    @Override
    public Campista findById(long id) {
        return campistaRepository.findCampistaById(id);
    }
}
