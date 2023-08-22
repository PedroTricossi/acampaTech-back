package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.Acampamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcampamentoRepository extends JpaRepository<Acampamento, Long> {
    @Query(value = "SELECT ACAM.id, ACAM.nome, ACAM.edicao, ACAM.tema, ACAM.data_inicio, ACAM.data_fim FROM acampamento ACAM INNER JOIN inscricoes_abertas IA ON ACAM.ID = IA.acampamento_id;", nativeQuery = true)
    public List<Acampamento> findAcampamentoOpen();

    @Query(value = "SELECT id, data_fim, data_inicio, edicao, nome, tema FROM public.acampamento WHERE data_inicio >= CURRENT_DATE AND data_inicio <= CURRENT_DATE + INTERVAL '3 MONTH';",
    nativeQuery = true)
    public List<Acampamento> findAcampamentoByCloseToNow();

    public Acampamento findAcampamentoById(Long id);


    @Query(value = "SELECT ACAMP.id, ACAMP.data_fim, ACAMP.data_inicio, ACAMP.edicao, ACAMP.nome, ACAMP.tema \n" +
            "FROM ACAMPAMENTO ACAMP\n" +
            "INNER JOIN INSCRICAO INSC ON ACAMP.id = INSC.acampamento_id\n" +
            "WHERE INSC.CAMPISTA_ID = :id",
    nativeQuery = true)
    public List<Acampamento> findAcampamentoIncritosByCampistaId(@Param("id")Long campistaId);
}
