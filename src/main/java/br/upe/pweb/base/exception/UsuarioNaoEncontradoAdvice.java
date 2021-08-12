package br.upe.pweb.base.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class UsuarioNaoEncontradoAdvice {

  @ExceptionHandler(RecursoNaoEncontradoException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  protected ControleAcessoExceptionDetalhe recursoNaoEncontradoExceptionHandler(Exception ex,
      WebRequest request) {

    log.error("Erro ao solicitar recurso inexistente", ex);

    ControleAcessoExceptionDetalhe response = new ControleAcessoExceptionDetalhe()
        .setMensagem("O recurso solcitado não foi encontrado: " + ex.getMessage())
        .setDetalhe(request.getDescription(false)).setOcorrencia(LocalDateTime.now())
        .setStatus(HttpStatus.NOT_FOUND.value());

    return response;
  }

  @ExceptionHandler(Throwable.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  protected ControleAcessoExceptionDetalhe globalExceptionHandler(Exception ex,
      WebRequest request) {

    log.error("Ocorreu um erro inesperado", ex);

    ControleAcessoExceptionDetalhe response = new ControleAcessoExceptionDetalhe()
        .setMensagem("Ocorreu um erro ao processar a sua solicitação: " + ex.getMessage())
        .setDetalhe(request.getDescription(false)).setOcorrencia(LocalDateTime.now())
        .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

    return response;
  }

}
