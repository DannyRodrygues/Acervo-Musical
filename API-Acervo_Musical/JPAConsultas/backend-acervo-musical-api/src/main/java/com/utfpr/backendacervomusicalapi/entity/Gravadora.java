package com.utfpr.backendacervomusicalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "gravadora")
@Data
public class Gravadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_gravadora", nullable = false)
    private Long id;

    @Column(name = "nome_gravadora", length = 50)
    private String nomeGravadora;

    @Column(length = 50)
    private String pais;
}
