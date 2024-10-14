package com.portfolio.api_catalogo_filmes.controller;

import com.portfolio.api_catalogo_filmes.dto.DadosAtualizacaoFilme;
import com.portfolio.api_catalogo_filmes.dto.DadosFilme;
import com.portfolio.api_catalogo_filmes.model.Filme;
import com.portfolio.api_catalogo_filmes.model.Genero;
import com.portfolio.api_catalogo_filmes.repository.FilmesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmesRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarFilme(@RequestBody @Valid DadosFilme dados) {
        repository.save(new Filme(dados));
    }

    @GetMapping
    public List<DadosFilme> buscarFilmes() {
        return repository.findAll().stream().map(DadosFilme::new).toList();
    }

    @GetMapping("/{genero}")
    public List<DadosFilme> buscarFilmePorGenero(@PathVariable Genero genero) {
        return repository.findByGenero(genero);
    }

    @PutMapping
    @Transactional
    public void atualizarFilme(@RequestBody @Valid DadosAtualizacaoFilme dados) {
        Filme filme = repository.getReferenceById(dados.id());
        filme.atualizarFilme(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarFilme(@PathVariable Integer id) {
        Filme filme = repository.getReferenceById(id);
        repository.delete(filme);
    }
}
