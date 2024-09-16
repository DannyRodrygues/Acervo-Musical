package com.utfpr.backendacervomusicalapi.repository;

import com.utfpr.backendacervomusicalapi.entity.Cantor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantorRepository extends JpaRepository<Cantor, Long> {
}
