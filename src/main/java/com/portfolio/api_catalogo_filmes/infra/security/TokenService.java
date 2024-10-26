package com.portfolio.api_catalogo_filmes.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.portfolio.api_catalogo_filmes.domain.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String tokenJWTGenerator(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("root");
            return JWT.create()
                    .withIssuer("luisfmaiadc")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(expirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT: ", exception);
        }
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }
}
