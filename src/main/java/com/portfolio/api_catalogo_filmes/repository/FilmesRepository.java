package com.portfolio.api_catalogo_filmes.repository;

import com.portfolio.api_catalogo_filmes.dto.DadosFilme;
import com.portfolio.api_catalogo_filmes.domain.filme.Filme;
import com.portfolio.api_catalogo_filmes.domain.filme.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmesRepository extends JpaRepository<Filme, Integer> {
    List<DadosFilme> findByGenero(Genero genero);
}
