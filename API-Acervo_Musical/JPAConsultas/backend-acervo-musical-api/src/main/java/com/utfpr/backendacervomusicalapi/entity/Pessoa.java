package com.utfpr.backendacervomusicalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pessoa")
@Data

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pessoa", nullable = false)
    private Long id;

    @Column(name = "nome_pessoa", length = 70)
    private String nomePessoa;
}
