package com.portfolio.api_catalogo_filmes.repository;

import com.portfolio.api_catalogo_filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<Filme, Integer> {
}
