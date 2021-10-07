package com.mobi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class VotoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VotoException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public GlobalError CPFInvalido(VotoException ex) {
        return new GlobalError(ex.getMessage(), ex.getErrorReason());
    }

    @ExceptionHandler(UserException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public GlobalError UsuarioNaoEncontrado(VotoException ex) {
        return new GlobalError(ex.getMessage(), ex.getErrorReason());
    }

    @ExceptionHandler(SessaoException.class)
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
    public GlobalError NaoHaSessao(VotoException ex) {
        return new GlobalError(ex.getMessage(), ex.getErrorReason());
    }
}
