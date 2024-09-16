package com.utfpr.backendacervomusicalapi.repository;


import com.utfpr.backendacervomusicalapi.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
}
