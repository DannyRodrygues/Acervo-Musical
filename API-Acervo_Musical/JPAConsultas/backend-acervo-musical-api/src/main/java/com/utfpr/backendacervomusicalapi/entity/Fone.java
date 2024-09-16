package com.utfpr.backendacervomusicalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fone")
@Data

public class Fone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_fone", nullable = false)
    private Long id;

    @Column(length = 80)
    private String numero;

    @Column(length = 1)
    private String tipo;

    @ManyToOne
    @JoinColumn(name ="cod_pessoa", nullable = false)
    private Pessoa pessoa;
}
