package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.model.HierarquiaAcampamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HierarquiaAcampamentoRepository extends JpaRepository<HierarquiaAcampamento, Long> {

    public List<HierarquiaAcampamento> findHierarquiaAcampamentoByAcampamentoReferenciaId(Long acampamentoId);
}
