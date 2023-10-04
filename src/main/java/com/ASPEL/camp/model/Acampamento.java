package com.ASPEL.camp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Boolean inscricoesAbertas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "acampamentos_pode_trabalhar", joinColumns = @JoinColumn(name = "acampamento_id"), inverseJoinColumns = @JoinColumn(name = "pode_trabalhar_id"))
    private Set<Acampamento> acampamentosPodeTrabalhar = new HashSet<>();
}
