package com.portfolio.api_catalogo_filmes.controller;

import com.portfolio.api_catalogo_filmes.dto.DadosCadastroFilme;
import com.portfolio.api_catalogo_filmes.model.Filme;
import com.portfolio.api_catalogo_filmes.repository.FilmesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmesRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarFilme(@RequestBody @Valid DadosCadastroFilme dados) {
        repository.save(new Filme(dados));
    }
}
