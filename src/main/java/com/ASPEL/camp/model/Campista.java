package com.ASPEL.camp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Campista {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private String nome;
    private String nacionalidade;
    private String estadoCivil;
    private String escolaridade;
    private Date dataNascimento ;
    private String rg;
    private String orgaoExpeditor;
    private String cpf;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
