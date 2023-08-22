package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.model.InscricoesAbertas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricoesAbertasRepository extends JpaRepository<InscricoesAbertas, Long> {

}
