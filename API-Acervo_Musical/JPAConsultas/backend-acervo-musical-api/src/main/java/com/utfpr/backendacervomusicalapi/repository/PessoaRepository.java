package com.utfpr.backendacervomusicalapi.repository;

import com.utfpr.backendacervomusicalapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
