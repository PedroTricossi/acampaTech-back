package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.FormularioInscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<FormularioInscricao, Long>{
    public FormularioInscricao findByCampistaId(Long campistaId);
    public FormularioInscricao findByAcampamentoIdAndCampistaId(Long acampamentoId, Long campistaId);

    public void deleteByAcampamentoId(Long acampamentoId);
}
