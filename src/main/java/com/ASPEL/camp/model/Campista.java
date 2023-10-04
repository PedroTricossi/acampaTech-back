package com.ASPEL.camp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Set;

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


    @ManyToMany(targetEntity=Acampamento.class,
            fetch = FetchType.LAZY)
    @JoinTable(name = "acampamentos_realizados", joinColumns = @JoinColumn(name = "acampamento_id"), inverseJoinColumns = @JoinColumn(name = "campista_id"))
    private List<Acampamento> acampamentosRealizados;

}
