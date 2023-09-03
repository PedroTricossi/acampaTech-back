package com.ASPEL.camp.service;

import com.ASPEL.camp.model.HierarquiaAcampamento;

public interface HierarquiaAcampamentoService {
    Integer verificaHierarquiaAcampamento(Long campistaId, Long acampamentoId);

    HierarquiaAcampamento save(HierarquiaAcampamento hierarquiaAcampamento);
}
