package com.portfolio.api_catalogo_filmes.controller;

import com.portfolio.api_catalogo_filmes.dto.DadosAtualizacaoFilme;
import com.portfolio.api_catalogo_filmes.dto.DadosFilme;
import com.portfolio.api_catalogo_filmes.domain.filme.Filme;
import com.portfolio.api_catalogo_filmes.domain.filme.Genero;
import com.portfolio.api_catalogo_filmes.repository.FilmesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmesRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarFilme(@RequestBody @Valid DadosFilme dados, UriComponentsBuilder uriComponentsBuilder) {
        Filme filme = new Filme(dados);
        repository.save(filme);
        URI uri = uriComponentsBuilder.path("/filme/{id}").buildAndExpand(filme.getId()).toUri();
        return ResponseEntity.created(uri).body(dados);
    }

    @GetMapping
    public ResponseEntity<List<DadosFilme>> buscarFilmes() {
        var list = repository.findAll().stream().map(DadosFilme::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{genero}")
    public ResponseEntity<List<DadosFilme>> buscarFilmePorGenero(@PathVariable Genero genero) {
        var list = repository.findByGenero(genero);
        return ResponseEntity.ok(list);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarFilme(@RequestBody @Valid DadosAtualizacaoFilme dados) {
        Filme filme = repository.getReferenceById(dados.id());
        filme.atualizarFilme(dados);
        DadosFilme dadosFilmeAtualizado = new DadosFilme(filme);
        return ResponseEntity.ok(dadosFilmeAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarFilme(@PathVariable Integer id) {
        Filme filme = repository.getReferenceById(id);
        repository.delete(filme);
        return ResponseEntity.noContent().build();
    }
}
