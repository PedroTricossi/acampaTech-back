package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.AcampamentosCompletos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcampamentosCompletosRepository extends JpaRepository<AcampamentosCompletos, Long> {
    public List<AcampamentosCompletos> findAcampamentosCompletosByCampistaId(Long campistaId);

    public List<AcampamentosCompletos> findAcampamentosCompletosByAcampamentoId(Long acampamentoId);
}
