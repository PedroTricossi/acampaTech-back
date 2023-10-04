package com.ASPEL.camp.dto;

import com.ASPEL.camp.model.Acampamento;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
public class CampistaDto {
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

    List<String> acampamentosRealizados;
}
