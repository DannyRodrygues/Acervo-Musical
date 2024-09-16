package com.utfpr.backendacervomusicalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cantor")
@Data
public class Cantor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cantor", nullable = false)
    private Long id;

    @Column(name = "nome_cantor", length = 50)
    private String nomeCantor;

    @Column(length = 30)
    private String pais;
}
