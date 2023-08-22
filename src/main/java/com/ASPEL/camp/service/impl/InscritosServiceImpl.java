package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Inscritos;
import com.ASPEL.camp.repository.InscritosRepository;
import com.ASPEL.camp.service.InscritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscritosServiceImpl implements InscritosService {
    @Autowired
    InscritosRepository inscritosRepository;

    @Override
    public Inscritos save(Inscritos inscritos) {
        return inscritosRepository.save(inscritos);
    }
}
