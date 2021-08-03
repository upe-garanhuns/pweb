package br.upe.pweb.controleacesso.controle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsuarioNaoEncontradoAdvice {

  @ResponseBody
  @ExceptionHandler(UsuarioNaoEncontradoException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(UsuarioNaoEncontradoException ex) {
    return ex.getMessage();
  }

}
