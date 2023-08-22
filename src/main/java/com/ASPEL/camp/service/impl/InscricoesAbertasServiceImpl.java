package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.model.InscricoesAbertas;
import com.ASPEL.camp.repository.InscricoesAbertasRepository;
import com.ASPEL.camp.service.InscricoesAbertasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricoesAbertasServiceImpl implements InscricoesAbertasService {
    @Autowired
    InscricoesAbertasRepository inscricoesAbertasRepository;

    @Override
    public InscricoesAbertas save(InscricoesAbertas inscricoesAbertas) {
        return inscricoesAbertasRepository.save(inscricoesAbertas);
    }
}
