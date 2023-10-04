package com.ASPEL.camp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class FormularioInscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private Long campistaId;
    private Long acampamentoId;
    @NotBlank
    private String equipePreferencia;
    private String equipeEscolhida;
    private String familiaresAcampamento;
}
