package com.portfolio.api_catalogo_filmes.controller;

import com.portfolio.api_catalogo_filmes.domain.usuario.Usuario;
import com.portfolio.api_catalogo_filmes.dto.DadosJWT;
import com.portfolio.api_catalogo_filmes.dto.DadosLogin;
import com.portfolio.api_catalogo_filmes.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosLogin dadosLogin) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dadosLogin.email(), dadosLogin.password());
        var authentication = manager.authenticate(authenticationToken);
        var JWT = tokenService.tokenJWTGenerator((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosJWT(JWT));
    }

}
