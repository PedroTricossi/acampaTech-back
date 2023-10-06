package com.ASPEL.camp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(
uniqueConstraints = {
    @UniqueConstraint(columnNames = "nome"),
    @UniqueConstraint(columnNames = "rg"),
        @UniqueConstraint(columnNames = "cpf")
        })
public class Campista {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @NotEmpty
    private String nome;

    private String nacionalidade;

    private String estadoCivil;

    private String escolaridade;
    @Past
    private Date dataNascimento ;

    @NotEmpty
    private String rg;

    private String orgaoExpeditor;
    @NotEmpty
    @CPF
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
