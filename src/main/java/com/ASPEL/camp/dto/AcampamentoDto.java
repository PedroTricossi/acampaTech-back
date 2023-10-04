package com.ASPEL.camp.dto;

import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Data
public class AcampamentoDto {
    private Long Id;
    private String nome;
    private String edicao;
    private String tema;
    private Date dataInicio;
    private Date dataFim;
    private Boolean inscricoesAbertas;
    private Set<String> acampamentosPodeTrabalhar;
}
