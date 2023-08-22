package com.ASPEL.camp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AcampamentoTrabalhado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private Long campistaId;
    private Long acampamentoId;
}
