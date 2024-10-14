package com.portfolio.api_catalogo_filmes.model;

import com.portfolio.api_catalogo_filmes.dto.DadosAtualizacaoFilme;
import com.portfolio.api_catalogo_filmes.dto.DadosFilme;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "filme")
@Entity(name = "Filme")
public class Filme {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String diretor;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    public Filme(DadosFilme dados) {
        this.titulo = dados.titulo();
        this.diretor = dados.diretor();
        this.genero = dados.genero();
        this.anoLancamento = dados.anoLancamento();
    }

    public void atualizarFilme(DadosAtualizacaoFilme dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }

        if (dados.diretor() != null) {
            this.diretor = dados.diretor();
        }

        if (dados.genero() != null) {
            this.genero = dados.genero();
        }

        if (dados.anoLancamento() != null) {
            this.anoLancamento = dados.anoLancamento();
        }
    }
}
