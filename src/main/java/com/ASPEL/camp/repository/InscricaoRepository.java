package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long>{
    public Inscricao findByCampistaId(Long campistaId);
    public Inscricao findByAcampamentoIdAndCampistaId(Long acampamentoId, Long campistaId);

    public void deleteByAcampamentoId(Long acampamentoId);
}
