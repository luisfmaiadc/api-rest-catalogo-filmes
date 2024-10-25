package com.portfolio.api_catalogo_filmes.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    public ResponseEntity handleEntityNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleInvalidArgument(MethodArgumentNotValidException exception) {
        var error =exception.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(DadosErroCadastro::new).toList());
    }

    private record DadosErroCadastro(String campo, String mensagem) {
        DadosErroCadastro(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

}
