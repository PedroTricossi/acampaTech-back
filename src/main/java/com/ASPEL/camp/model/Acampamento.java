package com.ASPEL.camp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Acampamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String nome;
    private String edicao;
    private String tema;
    private Date dataInicio;
    private Date dataFim;
}
