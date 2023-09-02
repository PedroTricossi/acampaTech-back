package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.InscricoesAbertas;
import com.ASPEL.camp.repository.InscricoesAbertasRepository;
import com.ASPEL.camp.service.InscricoesAbertasService;
import org.springframework.stereotype.Service;

@Service
public class InscricoesAbertasServiceImpl implements InscricoesAbertasService {

    private final InscricoesAbertasRepository inscricoesAbertasRepository;

    public InscricoesAbertasServiceImpl(InscricoesAbertasRepository inscricoesAbertasRepository) {
        this.inscricoesAbertasRepository = inscricoesAbertasRepository;
    }

    @Override
    public InscricoesAbertas save(InscricoesAbertas inscricoesAbertas) {
        return inscricoesAbertasRepository.save(inscricoesAbertas);
    }
}
