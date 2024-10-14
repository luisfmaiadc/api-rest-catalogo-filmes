package com.portfolio.api_catalogo_filmes.dto;

import com.portfolio.api_catalogo_filmes.model.Filme;
import com.portfolio.api_catalogo_filmes.model.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosFilme(@NotBlank String titulo, @NotBlank String diretor, @NotNull Genero genero, @NotNull Integer anoLancamento) {

    public DadosFilme(Filme filme) {
        this(filme.getTitulo(), filme.getDiretor(), filme.getGenero(), filme.getAnoLancamento());
    }
}
