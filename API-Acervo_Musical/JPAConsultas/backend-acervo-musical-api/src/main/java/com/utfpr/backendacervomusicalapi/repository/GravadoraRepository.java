package com.utfpr.backendacervomusicalapi.repository;


import com.utfpr.backendacervomusicalapi.entity.Gravadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GravadoraRepository extends JpaRepository<Gravadora, Long> {
}
