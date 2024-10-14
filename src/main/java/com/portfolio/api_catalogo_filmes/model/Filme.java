package com.portfolio.api_catalogo_filmes.model;

import com.portfolio.api_catalogo_filmes.dto.DadosCadastroFilme;
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

    public Filme(DadosCadastroFilme dados) {
        this.titulo = dados.titulo();
        this.diretor = dados.diretor();
        this.genero = dados.genero();
        this.anoLancamento = dados.anoLancamento();
    }

}
