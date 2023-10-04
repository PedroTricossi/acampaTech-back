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
    @NotEmpty
    private String nacionalidade;
    @NotEmpty
    private String estadoCivil;
    @NotEmpty
    private String escolaridade;
    @Past
    @NotEmpty
    private Date dataNascimento ;
    @NotEmpty
    private String rg;
    @NotEmpty
    private String orgaoExpeditor;
    @NotEmpty
    @CPF
    private String cpf;
    @NotEmpty
    private String endereco;
    @NotEmpty
    private String bairro;
    @NotEmpty
    private String cidade;
    @NotEmpty
    private String estado;
    @NotEmpty
    private String cep;


    @ManyToMany(targetEntity=Acampamento.class,
            fetch = FetchType.LAZY)
    @JoinTable(name = "acampamentos_realizados", joinColumns = @JoinColumn(name = "acampamento_id"), inverseJoinColumns = @JoinColumn(name = "campista_id"))
    private List<Acampamento> acampamentosRealizados;

}
