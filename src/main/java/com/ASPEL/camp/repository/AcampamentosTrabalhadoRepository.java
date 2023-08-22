package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.AcampamentoTrabalhado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcampamentosTrabalhadoRepository extends JpaRepository<AcampamentoTrabalhado, Long> {
    public List<AcampamentoTrabalhado> findAcampamentoTrabalhadoByCampistaId(Long campistaId);

    public List<AcampamentoTrabalhado> findAcampamentoTrabalhadoByAcampamentoId(Long acampamentoId);
}
