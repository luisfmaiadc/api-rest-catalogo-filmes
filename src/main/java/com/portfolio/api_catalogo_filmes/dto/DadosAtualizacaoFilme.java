package com.portfolio.api_catalogo_filmes.dto;

import com.portfolio.api_catalogo_filmes.domain.filme.Genero;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFilme(@NotNull Integer id, String titulo, String diretor, Genero genero, Integer anoLancamento) {
}
