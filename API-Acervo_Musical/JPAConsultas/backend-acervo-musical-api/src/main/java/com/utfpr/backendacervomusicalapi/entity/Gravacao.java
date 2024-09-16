package com.utfpr.backendacervomusicalapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "gravacao")
@Data

public class Gravacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_gravacao", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_gravadora", nullable = false)
    private Gravadora gravadora;

    @ManyToOne
    @JoinColumn(name = "cod_cantor", nullable = false)
    private Cantor cantor;

    @ManyToOne
    @JoinColumn(name = "cod_musica", nullable = false)
    private Musica musica;

    @DateTimeFormat
    @Column(name ="data_gravacao")
    private Date dataGravacao;


}
