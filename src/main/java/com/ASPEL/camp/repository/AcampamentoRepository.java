package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.Acampamento;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcampamentoRepository extends JpaRepository<Acampamento, Long> {
    @Query(value = "SELECT * FROM public.acampamento WHERE data_inicio >= CURRENT_DATE AND data_inicio <= CURRENT_DATE + INTERVAL '3 MONTH';",
    nativeQuery = true)
    public List<Acampamento> findAcampamentoByCloseToNow();

    public Acampamento findAcampamentoById(Long id);

    Optional<Acampamento> findAcampamentoByNome(String name);

    @Query(value = "SELECT ACAMP.id, ACAMP.data_fim, ACAMP.data_inicio, ACAMP.edicao, ACAMP.nome, ACAMP.tema, ACAMP.inscricoes_abertas\n" +
            "FROM ACAMPAMENTO ACAMP\n" +
            "INNER JOIN formulario_inscricao INSC ON ACAMP.id = INSC.acampamento_id\n" +
            "WHERE INSC.CAMPISTA_ID = :id",
    nativeQuery = true)
    public List<Acampamento> findAcampamentoIncritosByCampistaId(@Param("id")Long campistaId);
}
