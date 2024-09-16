package com.utfpr.backendacervomusicalapi.repository;


import com.utfpr.backendacervomusicalapi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
