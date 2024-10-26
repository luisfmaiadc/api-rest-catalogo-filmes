package com.portfolio.api_catalogo_filmes.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(@NotBlank String email, @NotBlank String password) {
}
