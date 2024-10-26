package com.portfolio.api_catalogo_filmes.controller;

import com.portfolio.api_catalogo_filmes.dto.DadosLogin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosLogin dadosLogin) {
        var token = new UsernamePasswordAuthenticationToken(dadosLogin.email(), dadosLogin.password());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }

}
