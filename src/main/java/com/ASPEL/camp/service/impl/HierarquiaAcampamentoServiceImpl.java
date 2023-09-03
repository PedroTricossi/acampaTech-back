package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.model.AcampamentosCompletos;
import com.ASPEL.camp.model.HierarquiaAcampamento;
import com.ASPEL.camp.repository.AcampamentosCompletosRepository;
import com.ASPEL.camp.repository.HierarquiaAcampamentoRepository;
import com.ASPEL.camp.service.HierarquiaAcampamentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HierarquiaAcampamentoServiceImpl implements HierarquiaAcampamentoService {

    private final HierarquiaAcampamentoRepository hierarquiaAcampamentoRepository;
    private final AcampamentosCompletosRepository acampamentosCompletosRepository;

    public HierarquiaAcampamentoServiceImpl(HierarquiaAcampamentoRepository hierarquiaAcampamentoRepository, AcampamentosCompletosRepository acampamentosCompletosRepository) {
        this.hierarquiaAcampamentoRepository = hierarquiaAcampamentoRepository;
        this.acampamentosCompletosRepository = acampamentosCompletosRepository;
    }

    @Override
    public Integer verificaHierarquiaAcampamento(Long campistaId, Long acampamentoId) {
        List<HierarquiaAcampamento> hierarquiaAcampamentoList = hierarquiaAcampamentoRepository.findHierarquiaAcampamentoByAcampamentoReferenciaId(acampamentoId);
        List<AcampamentosCompletos> acampamentosCompletosList = acampamentosCompletosRepository.findAcampamentosCompletosByCampistaId(campistaId);

        for (HierarquiaAcampamento hierarquiaAcampamento : hierarquiaAcampamentoList) {
            for (AcampamentosCompletos acampamentosCompletos : acampamentosCompletosList) {
                if (hierarquiaAcampamento.getAcampamentoPermissaoId().equals(acampamentosCompletos.getAcampamentoId())) {
                    return 1;
                }
            }
        }

        return 0;
    }

    @Override
    public HierarquiaAcampamento save(HierarquiaAcampamento hierarquiaAcampamento) {
        return hierarquiaAcampamentoRepository.save(hierarquiaAcampamento);
    }
}
