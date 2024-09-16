package com.utfpr.backendacervomusicalapi.repository;

import com.utfpr.backendacervomusicalapi.entity.Gravacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GravacaoRepository extends JpaRepository<Gravacao, Long> {
}
