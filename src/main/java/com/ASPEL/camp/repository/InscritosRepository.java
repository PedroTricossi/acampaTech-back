package com.ASPEL.camp.repository;

import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.model.Inscritos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscritosRepository extends JpaRepository<Inscritos, Long> {
}
