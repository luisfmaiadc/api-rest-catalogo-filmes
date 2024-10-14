package com.portfolio.api_catalogo_filmes.model;

public enum Genero {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    DRAMA("Drama"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    ROMANCE("Romance"),
    SUSPENSE("Suspense"),
    TERROR("Terror"),
    FANTASIA("Fantasia"),
    ANIMACAO("Animação");

    private String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
