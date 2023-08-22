package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.Campista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampistaRepository extends JpaRepository<Campista, Long> {
    public Campista findCampistaById(long Id);

    @Query(value = "SELECT CAMP.id, CAMP.bairro, CAMP.cep, CAMP.cidade, CAMP.cpf, CAMP.data_nascimento, CAMP.endereco, CAMP.escolaridade, CAMP.estado, CAMP.estado_civil, CAMP.nacionalidade, CAMP.nome, CAMP.orgao_expeditor, CAMP.rg \n" +
            "FROM campista CAMP \n" +
            "INNER JOIN INSCRICAO INSCR ON CAMP.ID = INSCR.CAMPISTA_ID\n" +
            "WHERE INSCR.ACAMPAMENTO_ID = :id",
    nativeQuery = true)
    public List<Campista> findCampistasIncritosByAcampamentoId(@Param("id") Long id);
}
